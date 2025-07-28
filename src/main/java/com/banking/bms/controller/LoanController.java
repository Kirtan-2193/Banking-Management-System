package com.banking.bms.controller;

import com.banking.bms.model.LoanCalculate;
import com.banking.bms.model.LoanInfoModel;
import com.banking.bms.model.UserLoanModal;
import com.banking.bms.services.LoanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;


    @GetMapping("/calculate")
    public ResponseEntity<LoanCalculate> calculateEMI(@RequestParam double loanAmount,
                                                      @RequestParam double interestRate,
                                                      @RequestParam int termMonths) {
        return ResponseEntity.ok(loanService.calculateLoanEMI(loanAmount, interestRate, termMonths));
    }

    @PostMapping("/apply")
    public ResponseEntity<LoanInfoModel> applyLoan(@Valid @RequestBody LoanInfoModel loanInfoModel,
                                                   @RequestParam Long accountNumber) {
        return ResponseEntity.ok(loanService.applyLoan(loanInfoModel, accountNumber));
    }

    @GetMapping("/all-loans")
    public ResponseEntity<List<UserLoanModal>> getAllLoans(@RequestParam(required = false) Long loanNumber) {
        return ResponseEntity.ok(loanService.getAllLoans(loanNumber));
    }

    @PutMapping("/approve")
    public ResponseEntity<UserLoanModal> approveLoan(@RequestParam Long loanNumber,
                                                     @RequestParam String email) {
        return ResponseEntity.ok(loanService.approveLoan(loanNumber, email));
    }

    @PutMapping("/reject")
    public ResponseEntity<UserLoanModal> rejectLoan(@RequestParam Long loanNumber,
                                                    @RequestParam String email,
                                                    @RequestParam String remarks) {
        return ResponseEntity.ok(loanService.rejectLoan(loanNumber, email, remarks));
    }
}
