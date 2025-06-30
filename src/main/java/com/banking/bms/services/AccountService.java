package com.banking.bms.services;

import com.banking.bms.mappers.AccountMapper;
import com.banking.bms.mappers.UserMapper;
import com.banking.bms.model.UserAccountModel;
import com.banking.bms.repository.AccountRepository;
import com.banking.bms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    private final UserRepository userRepository;

    private final UserMapper userMapper;



    public String insertAccount(UserAccountModel userAccountModel, String userId) {
        return null;
    }
}
