package com.banking.bms.model;

import lombok.Data;

@Data
public class LoanCalculate {

    private double loanAmount;

    private double interestRate;

    private int termMonths;

    private double emi;
}
