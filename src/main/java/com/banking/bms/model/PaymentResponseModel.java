package com.banking.bms.model;

import com.banking.bms.enumerations.PaymentStatus;
import lombok.Data;

@Data
public class PaymentResponseModel {

    private String paymentId;

    private double amount;

    private String paymentStatus;
}
