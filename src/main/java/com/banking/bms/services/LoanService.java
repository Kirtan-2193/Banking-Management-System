package com.banking.bms.services;

import com.banking.bms.enumerations.LoanStatus;
import com.banking.bms.enumerations.Status;
import com.banking.bms.exceptions.DataNotFoundException;
import com.banking.bms.exceptions.DataValidationException;
import com.banking.bms.mappers.LoanMapper;
import com.banking.bms.mappers.RoleMapper;
import com.banking.bms.mappers.UserMapper;
import com.banking.bms.model.EmiPaidCountModel;
import com.banking.bms.model.LoanCalculate;
import com.banking.bms.model.LoanInfoModel;
import com.banking.bms.model.MessageModel;
import com.banking.bms.model.RoleModel;
import com.banking.bms.model.UserDetailModel;
import com.banking.bms.model.UserLoanModal;
import com.banking.bms.model.entities.Account;
import com.banking.bms.model.entities.Loan;
import com.banking.bms.model.entities.User;
import com.banking.bms.model.entities.UserRole;
import com.banking.bms.repository.AccountRepository;
import com.banking.bms.repository.LoanRepository;
import com.banking.bms.repository.UserRepository;
import com.banking.bms.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoanService {

    private final LoanRepository loanRepository;

    private final AccountRepository accountRepository;

    private final UserRepository userRepository;

    private final UserRoleRepository userRoleRepository;

    private final AccountService accountService;

    private final EmailService emailService;

    private final LoanMapper loanMapper;

    private final RoleMapper roleMapper;

    private final UserMapper userMapper;



    public double calculateEMI(double loanAmount, double loanInterest, int loanTerm) {
        double monthlyInterestRate = loanInterest / (12 * 100);
        double emi = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTerm))
                / (Math.pow(1 + monthlyInterestRate, loanTerm) - 1);
        return BigDecimal.valueOf(emi)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public LoanCalculate calculateLoanEMI(double loanAmount, double interestRate, int termMonths) {

        double emi = calculateEMI(loanAmount, interestRate, termMonths);

        LoanCalculate loanCalculate = new LoanCalculate();
        loanCalculate.setLoanAmount(loanAmount);
        loanCalculate.setInterestRate(interestRate);
        loanCalculate.setTermMonths(termMonths);
        loanCalculate.setEmi(emi);

        return loanCalculate;
    }


    public LoanInfoModel applyLoan(LoanInfoModel loanInfoModel, Long accountNumber, String email) {

        Account account = null;
        User user = userRepository.findByEmail(email);
        List<Account> accountList = accountRepository.findByUserUserId(user.getUserId());

        for (Account ac : accountList) {
            Long number = ac.getAccountNumber();
            if (number.equals(accountNumber)) {
                account = ac;
                break;
            }
        }

        if (account == null) {
            throw new DataNotFoundException("Account not found with account number: "+accountNumber+" " +
                    "Please enter valid Account Number");
        }

        double emi = calculateEMI(loanInfoModel.getLoanAmount(), loanInfoModel.getInterestRate(), loanInfoModel.getLoanTerm());

        Loan loan = loanMapper.loanInfoModelToLoan(loanInfoModel);
        loan.setAccountNumber(account.getAccountNumber());
        loan.setEndDate(loanInfoModel.getStartDate().plusMonths(loanInfoModel.getLoanTerm()));
        loan = loanRepository.save(loan);

        LoanInfoModel returnLoanInfoModel = loanMapper.loanToLoanInfoModel(loan);
        returnLoanInfoModel.setEmi(emi);

        return returnLoanInfoModel;
    }


    public List<UserLoanModal> getAllLoans(Long loanNumber) {

        List<Loan> loanList = loanRepository.findAllLoan(loanNumber);

        return loanList.stream().map(loan -> {

            Account account = accountRepository.findByAccountNumber(loan.getAccountNumber()).orElseThrow(()
                    -> new DataValidationException("Account not found"));
            User user = userRepository.findByEmail(account.getUser().getEmail());

            UserLoanModal userLoanModal = userMapper.userToUserLoanModal(user);
            userLoanModal.setAccountNumber(loan.getAccountNumber());
            LoanInfoModel loanInfoModel = loanMapper.loanToLoanInfoModel(loan);
            loanInfoModel.setEmi(calculateEMI(loan.getLoanAmount(), loan.getInterestRate(), loan.getLoanTerm()));
            userLoanModal.setLoanInfoModel(loanInfoModel);

            UserDetailModel userDetailModel = new UserDetailModel();

            if (loan.getApprovedBy() != null) {
                userDetailModel = getUserDetail(loan.getApprovedBy().getEmail());
            } else {
                userDetailModel = null;
            }

            userLoanModal.setApprovedBy(userDetailModel);
            return userLoanModal;
        }).toList();
    }



    public UserLoanModal approveLoan(Long loanNumber, String email) {
        Loan loan = loanRepository.findByLoanNumber(loanNumber);

        Account account = accountRepository.findByAccountNumber(loan.getAccountNumber()).orElseThrow(() ->
                new DataValidationException("Account not found"));
        User user = userRepository.findByEmail(account.getUser().getEmail());
        double emi = calculateEMI(loan.getLoanAmount(), loan.getInterestRate(), loan.getLoanTerm());

        User approver = userRepository.findByEmail(email);
        loan.setApprovedBy(approver);
        loan.setLoanStatus(LoanStatus.APPROVED);
        Loan savedLoan = loanRepository.save(loan);

        emailService.loanApprovalEmail(user, account, savedLoan, emi);

        return approveOrRejectLoan(savedLoan, approver);
    }


    @Scheduled(cron = "0 0 10 * * ?") // Every day at 10:00 AM
    @Transactional
    public MessageModel activateLoan() {
        log.info("Activate Loan method triggered at " + LocalDateTime.now());

        List<Loan> loanList = loanRepository.findByLoanStatusAndStartDate(LoanStatus.APPROVED, LocalDate.now());
        String mgs = "";

        for (Loan loan : loanList) {
            Account account = accountRepository.findByAccountNumber(loan.getAccountNumber()).orElseThrow(() ->
                    new DataValidationException("Account not found"));
            User user = userRepository.findByEmail(account.getUser().getEmail());

            accountService.credit(account, user, loan.getLoanAmount());
            loan.setLoanStatus(LoanStatus.ACTIVE);
            loan.setNextEmiDueDate(loan.getStartDate().plusMonths(1));
            loanRepository.save(loan);

            mgs = "Loan activated successfully";
        }
        MessageModel messageModel = new MessageModel();
        messageModel.setMessage(mgs);
        return messageModel;
    }


    public UserLoanModal rejectLoan(Long loanNumber, String email, String remarks) {
        Loan loan = loanRepository.findByLoanNumber(loanNumber);

        Account account = accountRepository.findByAccountNumber(loan.getAccountNumber()).orElseThrow(() ->
                new DataValidationException("Account not found"));
        User user = userRepository.findByEmail(account.getUser().getEmail());

        User approver = userRepository.findByEmail(email);
        loan.setApprovedBy(approver);
        loan.setRemarks(remarks);
        loan.setLoanStatus(LoanStatus.REJECTED);
        Loan savedLoan = loanRepository.save(loan);

        emailService.loanRejectionEmail(user,account, savedLoan);

        return approveOrRejectLoan(savedLoan, approver);
    }


    @Transactional
    @Scheduled(cron = "0 30 10 * * ?") // Every Day at 10:30 AM
    public MessageModel payEMI(){
        log.info("EMI scheduler triggered at " + LocalDateTime.now());

        List<Loan> loanList = loanRepository.findByLoanStatusAndNextEmiDueDate(LoanStatus.ACTIVE, LocalDate.now());
        String mgs = "No EMI to pay";

        for (Loan loan : loanList) {
            Account account = accountRepository.findByAccountNumber(loan.getAccountNumber()).orElseThrow(() ->
                    new DataValidationException("Account not found"));
            User user = userRepository.findByEmail(account.getUser().getEmail());

            double emi = calculateEMI(loan.getLoanAmount(), loan.getInterestRate(), loan.getLoanTerm());

            accountService.debit(account, user, emi);

            List<EmiPaidCountModel> existingEmipaidCountModelList = loan.getEmiPaidCount();

            int count = existingEmipaidCountModelList.stream().mapToInt(c ->
                    c.getEmiPaidCount()).max().orElse(0);
            if (count >= loan.getLoanTerm()) {
                loan.setLoanStatus(LoanStatus.CLOSED);
                loan.setNextEmiDueDate(null);
            } else {

                EmiPaidCountModel emiPaidCountModel = new EmiPaidCountModel();
                emiPaidCountModel.setEmiPaidCount(count + 1);
                emiPaidCountModel.setEmiAmount(emi);
                emiPaidCountModel.setDateTime(String.valueOf(LocalDateTime.now()));
                existingEmipaidCountModelList.add(emiPaidCountModel);

                loan.setEmiPaidCount(existingEmipaidCountModelList);
                loan.setLoanStatus(LoanStatus.ACTIVE);
                loan.setNextEmiDueDate(loan.getNextEmiDueDate().plusMonths(1));

                loanRepository.save(loan);
                emailService.loanPaymentEmail(user, account, loan, emi, count + 1);
                mgs = "EMI paid successfully";
            }
        }
        MessageModel messageModel = new MessageModel();
        messageModel.setMessage(mgs);
        return messageModel;
    }



    public UserLoanModal approveOrRejectLoan(Loan loan, User approver) {
        Account account = accountRepository.findByAccountNumber(loan.getAccountNumber()).orElseThrow(() ->
                new DataValidationException("Account not found"));
        User user = userRepository.findByEmail(account.getUser().getEmail());

        UserLoanModal userLoanModal = userMapper.userToUserLoanModal(user);
        userLoanModal.setAccountNumber(loan.getAccountNumber());
        LoanInfoModel loanInfoModel = loanMapper.loanToLoanInfoModel(loan);
        loanInfoModel.setEmi(calculateEMI(loan.getLoanAmount(), loan.getInterestRate(), loan.getLoanTerm()));
        userLoanModal.setLoanInfoModel(loanInfoModel);
        userLoanModal.setApprovedBy(getUserDetail(approver.getEmail()));

        return userLoanModal;
    }


    public UserDetailModel getUserDetail(String email) {

        Set<String> allowedRoles = Set.of("admin", "manager", "loan officer");

        User approver = userRepository.findByEmail(email);

        UserDetailModel userDetailModel = userMapper.userToUserDetailModel(approver);
        List<UserRole> byUserUserId = userRoleRepository.findByUserUserIdAndStatus(approver.getUserId(), Status.ACTIVE);
        List<RoleModel> roleModelList = new ArrayList<>();
        byUserUserId.forEach(ur -> roleModelList.add(roleMapper.roleToRoleModel(ur.getRole())));
        String role = roleModelList.stream().map(roleModel -> roleModel.getRoleName().trim())
                .filter(n -> allowedRoles.contains(n.toLowerCase())).findFirst().orElse(null);
        userDetailModel.setRole(role);

        return userDetailModel;
    }
}
