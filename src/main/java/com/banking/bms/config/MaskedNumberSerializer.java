package com.banking.bms.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class MaskedNumberSerializer extends JsonSerializer<Object> {

    private static final int VISIBLE_DIGITS = 4;


    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value == null) {
            gen.writeNull();
            return;
        }

        String str = value.toString();
        int length = str.length();

        if (length <= VISIBLE_DIGITS) {
            gen.writeString(str);
            return;
        }

        String masked = "X".repeat(length - VISIBLE_DIGITS) + str.substring(length - VISIBLE_DIGITS);
        gen.writeString(masked);
    }
}
