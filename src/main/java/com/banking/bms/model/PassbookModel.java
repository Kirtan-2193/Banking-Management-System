package com.banking.bms.model;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class PassbookModel {

    private LocalDateTime dateTime;

    private double credit;

    private double debit;

    private double balance;
}
