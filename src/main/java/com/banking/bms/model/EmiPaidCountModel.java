package com.banking.bms.model;

import lombok.Data;


@Data
public class EmiPaidCountModel {

    private int emiPaidCount;
    private double emiAmount;
    private String dateTime;
}
