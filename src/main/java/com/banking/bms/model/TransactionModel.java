package com.banking.bms.model;

import lombok.Data;

@Data
public class TransactionModel {

    private double amount;
    private TransferInfoModel transferTo;
    private TransferInfoModel transferFrom;
}
