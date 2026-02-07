package com.banking.bms.model;

import com.banking.bms.config.MaskedNumberSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
public class UserLoanModal {

    @JsonSerialize(using = MaskedNumberSerializer.class)
    private Long accountNumber;

    private String firstName;

    private String lastName;

    private String email;

    private LoanInfoModel loanInfoModel;

    private UserDetailModel approvedBy;
}
