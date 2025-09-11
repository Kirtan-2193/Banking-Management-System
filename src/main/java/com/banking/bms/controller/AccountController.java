package com.banking.bms.controller;

import com.banking.bms.model.AccountModel;
import com.banking.bms.model.MessageModel;
import com.banking.bms.model.TransactionModel;
import com.banking.bms.model.TransferMessageModel;
import com.banking.bms.model.UserAccountModel;
import com.banking.bms.model.UserPassbookModel;
import com.banking.bms.services.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/add-account")
    @PreAuthorize("@authService.hassPermission(T(com.banking.bms.enumerations.PermissionEnum).CREATE_ACCOUNT)")
    public ResponseEntity<UserAccountModel> addAccount(@Valid @RequestBody List<AccountModel> accountModel,
                                                       @RequestParam String email,
                                                       @RequestParam String otp) {
        return ResponseEntity.ok(accountService.insertAccount(accountModel, email, otp));
    }

    @GetMapping
    @PreAuthorize("@authService.hassPermission(T(com.banking.bms.enumerations.PermissionEnum).VIEW_ACCOUNT)")
    public ResponseEntity<UserAccountModel> getAccountByUserId(@RequestParam String userId) {
        return ResponseEntity.ok(accountService.getAccountByUser(userId));
    }

    @GetMapping("/search")
    @PreAuthorize("@authService.hassPermission(T(com.banking.bms.enumerations.PermissionEnum).VIEW_ALL_ACCOUNT)")
    public ResponseEntity<List<UserAccountModel>> getAllUsersAccount(@RequestParam(required = false) Long search) {
        return ResponseEntity.ok(accountService.getAllAccount(search));
    }

    @PostMapping("/net-banking")
    @PreAuthorize("@authService.hassPermission(T(com.banking.bms.enumerations.PermissionEnum).TRANSFER_TRANSACTION)")
    public ResponseEntity<TransactionModel> onlineTransaction(@RequestParam Long fromAccountNumber,
                                                              @RequestParam Long toAccountNumber,
                                                              @RequestParam double transferAmount) {
        return ResponseEntity.ok(accountService.transferMoney(fromAccountNumber, toAccountNumber, transferAmount));
    }

    @PostMapping("/deposit")
    @PreAuthorize("@authService.hassPermission(T(com.banking.bms.enumerations.PermissionEnum).DEPOSIT_TRANSACTION)")
    public ResponseEntity<TransferMessageModel> depositMoney(@RequestParam Long accountNumber,
                                                             @RequestParam double depositAmount) {
        return ResponseEntity.ok(accountService.depositMoney(accountNumber, depositAmount));
    }

    @PostMapping("/withdraw")
    @PreAuthorize("@authService.hassPermission(T(com.banking.bms.enumerations.PermissionEnum).WITHDRAW_TRANSACTION)")
    public ResponseEntity<TransferMessageModel> withdrawMoney(@RequestParam Long accountNumber,
                                                              @RequestParam double withdrawAmount) {
        return ResponseEntity.ok(accountService.withdrawMoney(accountNumber, withdrawAmount));
    }

    @GetMapping("/passbook")
    @PreAuthorize("@authService.hassPermission(T(com.banking.bms.enumerations.PermissionEnum).VIEW_TRANSACTION)")
    public ResponseEntity<UserPassbookModel> getPassbookEntries(@RequestParam Long accountNumber,
                                                                @RequestParam(required = false, defaultValue = "DESC") String sortDirection) {
        return ResponseEntity.ok(accountService.getPassbook(accountNumber, sortDirection));
    }

    /*@PutMapping("/add-interest")
    public ResponseEntity<MessageModel> addInterestRate() {
        return ResponseEntity.ok(accountService.addInterestRate());
    }*/
}
