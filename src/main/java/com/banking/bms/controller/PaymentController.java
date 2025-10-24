package com.banking.bms.controller;

import com.banking.bms.model.PaymentResponseModel;
import com.banking.bms.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;


    @PostMapping
    public ResponseEntity<PaymentResponseModel> onlinePayment(@RequestParam Long accountNumber,
                                                              @RequestParam double amount) {
        return ResponseEntity.ok(paymentService.makeOnlinePayment(accountNumber, amount));
    }

    @GetMapping
    public ResponseEntity<PaymentResponseModel> Payment(@RequestParam Long accountNumber,
                                                              @RequestParam double amount) {
        return ResponseEntity.ok(paymentService.makeOnlinePayment(accountNumber, amount));
    }
}
