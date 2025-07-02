package com.banking.bms.controller;

import com.banking.bms.model.AccountModel;
import com.banking.bms.model.TransactionModel;
import com.banking.bms.model.UserAccountModel;
import com.banking.bms.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<UserAccountModel> addAccount(@RequestBody List<AccountModel> accountModel, @RequestParam String userId) {
        return ResponseEntity.ok(accountService.insertAccount(accountModel, userId));
    }

    @GetMapping
    public ResponseEntity<UserAccountModel> getAccountByUserId(@RequestParam String userId) {
        return ResponseEntity.ok(accountService.getAccountByUser(userId));
    }

    @PostMapping("/net-banking")
    public ResponseEntity<TransactionModel> onlineTransaction(@RequestParam Long fromAccountNumber,
                                                              @RequestParam Long toAccountNumber,
                                                              @RequestParam double transferAmount) {
        return ResponseEntity.ok(accountService.transferMoney(fromAccountNumber, toAccountNumber, transferAmount));
    }
}
