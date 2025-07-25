package com.banking.bms.services;

import com.banking.bms.exceptions.DataNotFoundException;
import com.banking.bms.exceptions.DataValidationException;
import com.banking.bms.mappers.AccountMapper;
import com.banking.bms.mappers.PassbookMapper;
import com.banking.bms.mappers.UserMapper;
import com.banking.bms.model.AccountModel;
import com.banking.bms.model.PassbookModel;
import com.banking.bms.model.TransactionModel;
import com.banking.bms.model.TransferInfoModel;
import com.banking.bms.model.UserAccountModel;
import com.banking.bms.model.UserPassbookModel;
import com.banking.bms.model.TransferMessageModel;
import com.banking.bms.model.entities.Account;
import com.banking.bms.model.entities.Passbook;
import com.banking.bms.model.entities.User;
import com.banking.bms.repository.AccountRepository;
import com.banking.bms.repository.PassbookRepository;
import com.banking.bms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PassbookRepository passbookRepository;

    private final PassbookMapper passbookMapper;



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

        log.info("account created successfully for userId: {}", userId);
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



    public List<UserAccountModel> getAllAccount(Long accountNumber) {

        if (accountNumber != null) {

            Account account = accountRepository.findByAccountNumber(accountNumber).orElseThrow(() ->
                    new DataNotFoundException("Account not found with account number: " + accountNumber));

            User user = userRepository.findByEmail(account.getUser().getEmail());

            List<Account> accountList = new ArrayList<>();
            accountList.add(account);

            List<AccountModel> accountModelList = accountMapper.accountListToAccountModelList(accountList);
            UserAccountModel userAccountModel = userMapper.userToUserAccountModel(user);
            userAccountModel.setAccountModelList(accountModelList);

            List<UserAccountModel> userAccountModelList = new ArrayList<>();
            userAccountModelList.add(userAccountModel);
            return userAccountModelList;
        }

        List<User> userList = userRepository.findAll();

        List<UserAccountModel> userAccountModelList = new ArrayList<>();
        userList.forEach(user -> {
            List<Account> accountList = accountRepository.findByUserUserId(user.getUserId());
            List<AccountModel> accountModelList = accountMapper.accountListToAccountModelList(accountList);
            UserAccountModel userAccountModel = userMapper.userToUserAccountModel(user);
            userAccountModel.setAccountModelList(accountModelList);
            if (accountModelList != null && !accountModelList.isEmpty()) {
                userAccountModelList.add(userAccountModel);
            }
        });

        return userAccountModelList;
    }



    /**
     * Transfers money from one account to another.
     *
     * This method performs the following steps:
     * - Validates that both source (fromAccountNumber) and destination (toAccountNumber) accounts exist.
     * - Retrieves associated users for both accounts using their email addresses.
     * - Constructs transfer information models for both sender and receiver.
     * - Debits the transfer amount from the source account.
     * - Credits the same amount to the destination account.
     * - Returns a TransactionModel that summarizes the transaction details.
     *
     * @param fromAccountNumber the account number from which money will be debited
     * @param toAccountNumber the account number to which money will be credited
     * @param transferAmount the amount of money to be transferred
     */
    @Transactional
    public TransactionModel transferMoney(Long fromAccountNumber, Long toAccountNumber, double transferAmount) {

        Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber).orElseThrow(() ->
                new DataNotFoundException("Account not found with account number: " + fromAccountNumber));
        User fromUser = userRepository.findByEmail(fromAccount.getUser().getEmail());

        Account toAccount = accountRepository.findByAccountNumber(toAccountNumber).orElseThrow(() ->
                new DataNotFoundException("Account not found with account number: " + toAccountNumber));
        User toUser = userRepository.findByEmail(toAccount.getUser().getEmail());

        TransferInfoModel fromTransferInfoModel = new TransferInfoModel();
        fromTransferInfoModel.setAccountNumber(fromAccount.getAccountNumber());
        fromTransferInfoModel.setFirstName(fromUser.getFirstName());
        fromTransferInfoModel.setEmail(fromUser.getEmail());

        TransferInfoModel toTransferInfoModel = new TransferInfoModel();
        toTransferInfoModel.setAccountNumber(toAccount.getAccountNumber());
        toTransferInfoModel.setFirstName(toUser.getFirstName());
        toTransferInfoModel.setEmail(toUser.getEmail());

        debit(fromAccount, fromUser, transferAmount);
        credit(toAccount, toUser, transferAmount);

        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setAmount(transferAmount);
        transactionModel.setTransferFrom(fromTransferInfoModel);
        transactionModel.setTransferTo(toTransferInfoModel);

        return transactionModel;
    }



    @Transactional
    public TransferMessageModel withdrawMoney(Long accountNumber, double withdrawAmount) {

        Account account = accountRepository.findByAccountNumber(accountNumber).orElseThrow(() ->
                new DataNotFoundException("Account not found with account number: " + accountNumber));
        User user = userRepository.findByEmail(account.getUser().getEmail());

        debit(account, user, withdrawAmount);

        TransferMessageModel transferMessageModel = new TransferMessageModel();
        transferMessageModel.setAmount(withdrawAmount);
        transferMessageModel.setAccountNumber(accountNumber);
        transferMessageModel.setMessage("₹"+withdrawAmount+" Withdrawn successfully. Your new balance is ₹"+account.getAccountBalance());

        return transferMessageModel;
    }



    @Transactional
    public TransferMessageModel depositMoney(Long accountNumber, double depositAmount) {
        Account account = accountRepository.findByAccountNumber(accountNumber).orElseThrow(() ->
                new DataNotFoundException("Account not found with account number: " + accountNumber));
        User user = userRepository.findByEmail(account.getUser().getEmail());

        credit(account, user, depositAmount);

        TransferMessageModel transferMessageModel = new TransferMessageModel();
        transferMessageModel.setAmount(depositAmount);
        transferMessageModel.setAccountNumber(accountNumber);
        transferMessageModel.setMessage("₹"+depositAmount+" Deposited successfully. Your new balance is ₹"+account.getAccountBalance());

        return transferMessageModel;
    }


    public UserPassbookModel getPassbook(Long accountNumber, String direction) {

        Sort sortDirection = Sort.by(Sort.Direction.fromString(direction), "dateTime");

        Account account = accountRepository.findByAccountNumber(accountNumber).orElseThrow(() ->
                new DataNotFoundException("Account not found with account number: " + accountNumber));
        User user = userRepository.findByEmail(account.getUser().getEmail());
        List<Passbook> passbookList = passbookRepository.findByAccountAccountId(account.getAccountId(), sortDirection);

        List<PassbookModel> passbookModelList = passbookMapper.passbookListToPassbookModelList(passbookList);

        UserPassbookModel userPassbookModel = new UserPassbookModel();
        userPassbookModel.setAccountNumber(accountNumber);
        userPassbookModel.setFirstName(user.getFirstName());
        userPassbookModel.setLastName(user.getLastName());
        userPassbookModel.setEmail(user.getEmail());
        userPassbookModel.setPassbook(passbookModelList);

        return userPassbookModel;
    }


    /**
     * Deducts the specified amount from the given account after validating balance constraints.
     *
     * This method performs the following checks and operations:
     * - Verifies if the account has enough balance to allow the debit.
     * - Ensures that the remaining balance after the debit is not below the required minimum balance.
     * - Updates the account balance and saves it to the repository.
     * - Adds a passbook entry for the debit transaction.
     *
     * Throws a DataValidationException in the following cases:
     * - If the account balance is insufficient for the requested debit.
     * - If the resulting balance after debit would fall below the minimum balance requirement.
     * - If the debit amount exactly equals the account balance (as this would violate the minimum balance rule).
     *
     * @param account the account from which money will be debited
     * @param user the user who owns the account
     * @param debitAmount the amount to be deducted from the account
     */
    public void debit (Account account, User user, double debitAmount) {

        double minimumBalance = 2000;

        if (account.getAccountBalance() > debitAmount) {

            double balance = account.getAccountBalance();
            double amount = debitAmount;
            double newBalance = balance - amount;

            if (newBalance >= minimumBalance) {
                account.setAccountBalance(newBalance);
                accountRepository.save(account);
                double totalBalance = account.getAccountBalance();

                passbookEntry(account, user, debitAmount, 0.0, totalBalance);
            } else {
                throw new DataValidationException("Minimum Balance Should be: " + minimumBalance);
            }
        } else if (account.getAccountBalance() == debitAmount) {
            throw new DataValidationException("Minimum Balance Should be: " + minimumBalance);
        } else {
            throw new DataValidationException("Insufficient Balance");
        }
    }



    /**
     * Adds the specified amount to the given account's balance and records the transaction.
     *
     * This method performs the following operations:
     * - Increases the account balance by the provided credit amount.
     * - Saves the updated account to the repository.
     * - Creates a passbook entry to record the credit transaction.
     *
     * @param account the account to which the amount will be credited
     * @param user the user who owns the account
     * @param creditAmount the amount to be added to the account balance
     */
    public void credit (Account account, User user, double creditAmount) {

        account.setAccountBalance(account.getAccountBalance() + creditAmount);
        accountRepository.save(account);
        double totalBalance = account.getAccountBalance();

        passbookEntry(account, user, 0.0, creditAmount, totalBalance);
    }


    public void passbookEntry (Account account, User user, double debitAmount, double creditAmount, double balance) {
        Passbook passbook = new Passbook();
        passbook.setAccount(account);
        passbook.setUser(user);
        passbook.setCredit(creditAmount);
        passbook.setDebit(debitAmount);
        passbook.setBalance(balance);
        passbookRepository.save(passbook);
    }
}
