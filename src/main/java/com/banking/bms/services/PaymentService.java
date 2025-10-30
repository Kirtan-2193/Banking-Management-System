package com.banking.bms.services;

import com.banking.bms.enumerations.PaymentStatus;
import com.banking.bms.exceptions.DataNotFoundException;
import com.banking.bms.mappers.PaymentMapper;
import com.banking.bms.model.PaymentResponseModel;
import com.banking.bms.model.entities.Account;
import com.banking.bms.model.entities.Payment;
import com.banking.bms.model.entities.User;
import com.banking.bms.repository.AccountRepository;
import com.banking.bms.repository.PaymentRepository;
import com.banking.bms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    private final AccountRepository accountRepository;

    private final UserRepository userRepository;

    private final PaymentMapper paymentMapper;

    private final AccountService accountService;


    @Transactional
    public PaymentResponseModel makeOnlinePayment(Long accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber).orElseThrow(
                () -> new DataNotFoundException("Account not found"));
        User user = account.getUser();

        boolean flag = accountService.debit(account, user, amount);

        Payment payment = new Payment();
        payment.setAccountNumber(accountNumber);
        payment.setAmount(amount);
        payment.setAccount(account);
        payment.setUpdateAt(LocalDateTime.now());
        payment.setPaymentStatus(flag ? PaymentStatus.SUCCESS : PaymentStatus.FAILED);

        return paymentMapper.paymentToPaymentResponseModel(paymentRepository.save(payment));
    }


    public PaymentResponseModel refundPayment(String paymentId) {
        Payment payment = paymentRepository.findByPaymentId(paymentId);

        Account account = accountRepository.findByAccountNumber(payment.getAccount().getAccountNumber()).orElseThrow(
                () -> new DataNotFoundException("Account not found"));
        User user = account.getUser();

        boolean flag = accountService.credit(account, user, payment.getAmount());

        payment.setPaymentStatus(flag ? PaymentStatus.REFUNDED : PaymentStatus.PENDING);
        payment.setUpdateAt(LocalDateTime.now());

        return paymentMapper.paymentToPaymentResponseModel(paymentRepository.save(payment));
    }
}
