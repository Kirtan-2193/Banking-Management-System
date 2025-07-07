package com.banking.bms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccountModel {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String accountId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String accountNumber;

    private String accountType;

    private String accountBranch;

    private double accountBalance;

}
