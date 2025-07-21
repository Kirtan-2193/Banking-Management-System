package com.banking.bms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanInfo {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long loanNumber;

    private double loanAmount;

    private double interestRate;

    private Integer loanTerm;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String loanStatus;

    private double EMI;

    private LocalDate startDate;

    private LocalDate endDate;
}
