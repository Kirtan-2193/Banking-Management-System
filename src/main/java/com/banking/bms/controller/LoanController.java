package com.banking.bms.controller;

import com.banking.bms.model.LoanCalculate;
import com.banking.bms.model.LoanInfo;
import com.banking.bms.services.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;


    @PostMapping("/calculate")
    public ResponseEntity<LoanCalculate> calculateEMI(@RequestParam double loanAmount,
                                                      @RequestParam double interestRate,
                                                      @RequestParam int termMonths) {
        return ResponseEntity.ok(loanService.calculateLoanEMI(loanAmount, interestRate, termMonths));
    }

    @PostMapping("/apply")
    public ResponseEntity<LoanInfo> applyLoan(@RequestBody LoanInfo loanInfo,
                                              @RequestParam String email) {
        return ResponseEntity.ok(loanService.applyLoan(loanInfo, email));
    }
}
