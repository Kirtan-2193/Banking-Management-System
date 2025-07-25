package com.banking.bms.model;

import lombok.Data;

@Data
public class UserLoanModal {

    private Long accountNumber;

    private String firstName;

    private String lastName;

    private String email;

    private LoanInfoModel loanInfoModel;

    private UserDetailModel approvedBy;
}
