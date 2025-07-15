package com.banking.bms.enumerations;

import lombok.Getter;

@Getter
public enum PermissionEnum {

    VIEW_ROLE,                  // -> Admin
    VIEW_USER,                  //-> Admin,Manager
    VIEW_ACCOUNT,               // -> Customer
    VIEW_ALL_ACCOUNT,           // -> Admin, Manager
    VIEW_TRANSACTION,           // -> Customer
    VIEW_ALL_TRANSACTION,       // -> Admin, Manager, Teller
    VIEW_LOAN,                  // -> Customer
    VIEW_ALL_LOAN,              // -> Admin, Manager, Loan Officer

    REGISTER_USER,              // -> Admin

    UPDATE_USER,                // -> Admin
    UPDATE_ACCOUNT,             // -> Admin, Manager

    CREATE_ACCOUNT,	            // -> Admin, Manager

    DELETE_USER,                // -> Admin
    DELETE_ACCOUNT,             // -> Admin, Manager

    DEPOSIT_TRANSACTION,        // -> Customer
    WITHDRAW_TRANSACTION,       // -> Customer
    TRANSFER_TRANSACTION,       // -> Customer

    APPLY_LOAN,                 // -> Customer

    LOAN_APPROVE,               // -> Admin, Manager, Loan Officer
    LOAN_REJECT                 // -> Admin, Manager, Loan Officer
}
