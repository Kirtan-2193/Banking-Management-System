package com.banking.bms.services;

import com.banking.bms.exceptions.DataValidationException;
import com.banking.bms.mappers.LoanMapper;
import com.banking.bms.model.LoanCalculate;
import com.banking.bms.model.LoanInfo;
import com.banking.bms.model.entities.Account;
import com.banking.bms.model.entities.Loan;
import com.banking.bms.model.entities.User;
import com.banking.bms.repository.AccountRepository;
import com.banking.bms.repository.LoanRepository;
import com.banking.bms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    private final LoanMapper loanMapper;

    private final AccountService accountService;

    private final UserRepository userRepository;

    private final AccountRepository accountRepository;



    public double calculateEMI(double loanAmount, double interestRate, int termMonths) {
        double monthlyInterestRate = interestRate / (12 * 100);
        double emi = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, termMonths))
                / (Math.pow(1 + monthlyInterestRate, termMonths) - 1);

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



    public LoanInfo applyLoan(LoanInfo loanInfo, String email) {

        User user = userRepository.findByEmail(email);
        Account account = accountRepository.findByUserEmail(user.getEmail()).orElseThrow(()
                -> new DataValidationException("Account not found"));

        accountService.credit(account, user, loanInfo.getLoanAmount());

        Loan loan = loanMapper.loanInfoToLoan(loanInfo);
        loan.setCustomerId(user);
        loan = loanRepository.save(loan);
        return loanMapper.loanToLoanInfo(loan);
    }
}
