package com.banking.bms.model;

import com.banking.bms.config.MaskedNumberSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.List;

@Data
public class UserModel {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String userId;

    private String firstName;

    private String lastName;

    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @JsonSerialize(using = MaskedNumberSerializer.class)
    private String phoneNumber;

    private String gender;

    private List<RoleModel> roles;
}
