package com.banking.bms.model;

import com.banking.bms.config.MaskedNumberSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransferMessageModel {

    private double amount;

    @JsonSerialize(using = MaskedNumberSerializer.class)
    private Long accountNumber;

    private LocalDateTime dateTime = LocalDateTime.now();

    private String message;
}
