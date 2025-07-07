package com.banking.bms.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransferMessageModel {

    private double amount;

    private Long accountNumber;

    private LocalDateTime dateTime = LocalDateTime.now();

    private String message;
}
