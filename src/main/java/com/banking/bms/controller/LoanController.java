package com.banking.bms.controller;

import com.banking.bms.model.LoanCalculate;
import com.banking.bms.model.LoanInfoModel;
import com.banking.bms.model.MessageModel;
import com.banking.bms.model.UserLoanModal;
import com.banking.bms.services.LoanService;
import com.banking.bms.util.SecurityUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("@authService.hassPermission(T(com.banking.bms.enumerations.PermissionEnum).APPLY_LOAN)")
    public ResponseEntity<LoanInfoModel> applyLoan(@Valid @RequestBody LoanInfoModel loanInfoModel,
                                                   @RequestParam Long accountNumber) {
        String email = SecurityUtils.getCurrentUserEmail();

        return ResponseEntity.ok(loanService.applyLoan(loanInfoModel, accountNumber, email));
    }

    @GetMapping("/all-loans")
    @PreAuthorize("@authService.hassPermission(T(com.banking.bms.enumerations.PermissionEnum).VIEW_ALL_LOAN)")
    public ResponseEntity<List<UserLoanModal>> getAllLoans(@RequestParam(required = false) Long loanNumber) {
        return ResponseEntity.ok(loanService.getAllLoans(loanNumber));
    }

    @PutMapping("/approve")
    @PreAuthorize("@authService.hassPermission(T(com.banking.bms.enumerations.PermissionEnum).LOAN_APPROVE)")
    public ResponseEntity<UserLoanModal> approveLoan(@RequestParam Long loanNumber) {
        String email = SecurityUtils.getCurrentUserEmail();

        return ResponseEntity.ok(loanService.approveLoan(loanNumber, email));
    }

    @PutMapping("/reject")
    @PreAuthorize("@authService.hassPermission(T(com.banking.bms.enumerations.PermissionEnum).LOAN_REJECT)")
    public ResponseEntity<UserLoanModal> rejectLoan(@RequestParam Long loanNumber,
                                                    @RequestParam String remarks) {
        String email = SecurityUtils.getCurrentUserEmail();

        return ResponseEntity.ok(loanService.rejectLoan(loanNumber, email, remarks));
    }

/*    @PutMapping("/pay-emi")
    public ResponseEntity<MessageModel> transferEMIs() {
        return ResponseEntity.ok(loanService.payEMI());
    }

    @PutMapping("/emi-active")
    public ResponseEntity<MessageModel> activeLoan() {
        return ResponseEntity.ok(loanService.activateLoan());
    }*/
}
