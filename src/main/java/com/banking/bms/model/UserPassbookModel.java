package com.banking.bms.model;

import lombok.Data;

import java.util.List;

@Data
public class UserPassbookModel {

    private Long accountNumber;

    private String firstName;

    private String lastName;

    private String email;

    private List<PassbookModel> passbook;
}
