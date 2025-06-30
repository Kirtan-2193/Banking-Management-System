package com.banking.bms.controller;

import com.banking.bms.model.UserAccountModel;
import com.banking.bms.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public String addAccount(@RequestBody UserAccountModel userAccountModel, @RequestParam String userId) {
        return null;
    }

}
