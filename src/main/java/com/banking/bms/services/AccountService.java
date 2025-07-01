package com.banking.bms.services;

import com.banking.bms.exceptions.DataNotFoundException;
import com.banking.bms.mappers.AccountMapper;
import com.banking.bms.mappers.UserMapper;
import com.banking.bms.model.AccountModel;
import com.banking.bms.model.TransactionModel;
import com.banking.bms.model.UserAccountModel;
import com.banking.bms.model.entities.Account;
import com.banking.bms.model.entities.User;
import com.banking.bms.repository.AccountRepository;
import com.banking.bms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    private final UserRepository userRepository;

    private final UserMapper userMapper;



    @Transactional
    public UserAccountModel insertAccount(List<AccountModel> accountModel, String userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(() ->
                new DataNotFoundException("User not found with userId: " + userId));

        List<Account> accountList = accountMapper.accountModelListToAccountList(accountModel);

        List<Account> saveAccount = new ArrayList<>();
        for (Account account : accountList) {
            account.setUser(user);
            saveAccount.add(accountRepository.save(account));
        }

        List<AccountModel> accountModelList = accountMapper.accountListToAccountModelList(saveAccount);
        UserAccountModel userAccountModel = userMapper.userToUserAccountModel(user);
        userAccountModel.setAccountModelList(accountModelList);

        return userAccountModel;
    }

    public UserAccountModel getAccountByUser(String userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(() ->
                new DataNotFoundException("User not found with userId: " + userId));

        List<Account> accountList = accountRepository.findByUserUserId(userId);

        List<AccountModel> accountModelList = accountMapper.accountListToAccountModelList(accountList);
        UserAccountModel userAccountModel = userMapper.userToUserAccountModel(user);
        userAccountModel.setAccountModelList(accountModelList);

        return userAccountModel;
    }


    /*public TransactionModel transferMoney(String fromAccountNumber, String toAccountNumber, double transferAmount) {

        Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber).orElseThrow(() ->
                new DataNotFoundException("Account not found with account number: " + fromAccountNumber));
        User fromUser = userRepository.findByEmail(fromAccount.getUser().getEmail());


    }*/
}
