package com.banking.bms.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmiPaidCountModel {

    private int emiPaidCount;
    private double emiAmount;
    private String dateTime;
}
