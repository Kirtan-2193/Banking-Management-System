package com.banking.bms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserAccountModel {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String userId;

    private String firstName;

    private String email;

    private List<AccountModel> accountModelList;
}
