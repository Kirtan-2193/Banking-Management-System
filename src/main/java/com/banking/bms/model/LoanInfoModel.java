package com.banking.bms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanInfoModel {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long loanNumber;

    @NotBlank(message = "Loan type is required")
    private String loanType;

    @NotBlank(message = "Loan amount is required")
    private double loanAmount;

    @NotBlank(message = "Interest rate is required")
    private double interestRate;

    @NotBlank(message = "Loan term is required")
    private Integer loanTerm;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String loanStatus;

    private double emi;

    @FutureOrPresent(message = "Start date must be today or a future date")
    @NotBlank(message = "Start date is required")
    private LocalDate startDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate endDate;

    private String remarks;
}
