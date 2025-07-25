package com.banking.bms.services;

import com.banking.bms.enumerations.Status;
import com.banking.bms.exceptions.DataValidationException;
import com.banking.bms.mappers.AccountMapper;
import com.banking.bms.mappers.LoanMapper;
import com.banking.bms.mappers.RoleMapper;
import com.banking.bms.mappers.UserMapper;
import com.banking.bms.model.*;
import com.banking.bms.model.entities.Account;
import com.banking.bms.model.entities.Loan;
import com.banking.bms.model.entities.User;
import com.banking.bms.model.entities.UserRole;
import com.banking.bms.repository.AccountRepository;
import com.banking.bms.repository.LoanRepository;
import com.banking.bms.repository.UserRepository;
import com.banking.bms.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    private final AccountRepository accountRepository;

    private final UserRepository userRepository;

    private final UserRoleRepository userRoleRepository;

    private final AccountService accountService;

    private final AccountMapper accountMapper;

    private final LoanMapper loanMapper;

    private final RoleMapper roleMapper;

    private final UserMapper userMapper;



    public double calculateEMI(double loanAmount, double loanInterest, int loanTerm) {
        double monthlyInterestRate = loanInterest / (12 * 100);
        double emi = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTerm))
                / (Math.pow(1 + monthlyInterestRate, loanTerm) - 1);

        return emi;
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


    public LoanInfoModel applyLoan(LoanInfoModel loanInfoModel, Long accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber).orElseThrow(()
                -> new DataValidationException("Account not found"));

        double emi = calculateEMI(loanInfoModel.getLoanAmount(), loanInfoModel.getInterestRate(), loanInfoModel.getLoanTerm());

        Loan loan = loanMapper.loanInfoModelToLoan(loanInfoModel);
        loan.setAccountNumber(accountNumber);
        loan.setEndDate(loanInfoModel.getStartDate().plusMonths(loanInfoModel.getLoanTerm()));
        loan = loanRepository.save(loan);

        LoanInfoModel returnLoanInfoModel = loanMapper.loanToLoanInfoModel(loan);
        returnLoanInfoModel.setEmi(emi);

        return returnLoanInfoModel;
    }


    public List<UserLoanModal> getAllLoans(Long loanNumber) {

        List<Loan> loanList = loanRepository.findByLoanNumber(loanNumber);

        Set<String> allowedRoles = Set.of("admin", "manager", "loan officer");

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
                User approver = userRepository.findByEmail(loan.getApprovedBy().getEmail());

                userDetailModel = userMapper.userToUserDetailModel(approver);
                List<UserRole> byUserUserId = userRoleRepository.findByUserUserIdAndStatus(approver.getUserId(), Status.ACTIVE);
                List<RoleModel> roleModelList = new ArrayList<>();
                byUserUserId.forEach(ur -> roleModelList.add(roleMapper.roleToRoleModel(ur.getRole())));
                String role = roleModelList.stream().map(roleModel -> roleModel.getRoleName().trim())
                        .filter(n -> allowedRoles.contains(n.toLowerCase())).findFirst().orElse(null);
                userDetailModel.setRole(role);
            } else {
                userDetailModel = null;
            }

            userLoanModal.setApprovedBy(userDetailModel);
            return userLoanModal;
        }).toList();
    }
}
