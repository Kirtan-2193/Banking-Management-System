package com.banking.bms.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageModel {

    private String message;

    private LocalDateTime timestamp = LocalDateTime.now();
}
