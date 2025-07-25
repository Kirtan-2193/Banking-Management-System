package com.banking.bms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanInfoModel {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long loanNumber;

    private String loanType;

    private double loanAmount;

    private double interestRate;

    private Integer loanTerm;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String loanStatus;

    private double emi;

    @FutureOrPresent(message = "Start date must be today or a future date")
    private LocalDate startDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate endDate;
}
