package com.banking.bms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountModel {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String accountId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String accountNumber;

    private String accountType;

    private double interestRate;

    private String accountBranch;

    private double accountBalance;

    @Pattern(regexp = "^(\\d{4}|\\d{6})$", message = "Transaction PIN must be 4 or 6 digits numeric")
    private String transactionPin;

}
