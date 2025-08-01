package com.banking.bms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanInfoModel {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long loanNumber;

    @NotNull(message = "Loan type is required")
    private String loanType;

    @NotNull(message = "Loan amount is required")
    private double loanAmount;

    @NotNull(message = "Interest rate is required")
    private double interestRate;

    @NotNull(message = "Loan term is required")
    private Integer loanTerm;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String loanStatus;

    private double emi;

    @FutureOrPresent(message = "Start date must be today or a future date")
    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate endDate;

    private String remarks;
}
