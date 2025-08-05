package com.banking.bms.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class BalanceEncryptDecryptConverter implements AttributeConverter<Double, String> {

    @Override
    public String convertToDatabaseColumn(Double attribute) {
        if (attribute == null) return null;
        return EncryptionUtil.encrypt(String.valueOf(attribute));
    }

    @Override
    public Double convertToEntityAttribute(String attribute) {
        if (attribute == null) return null;
        return Double.parseDouble(EncryptionUtil.decrypt(attribute));
    }
}
