package com.banking.bms.util;

import com.banking.bms.exceptions.EncryptDecryptException;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Slf4j
public class EncryptionUtil {

    private static final String SECRET_KEY = "L9xT2qW7mA5zB3cV";
    private static final String ALGORITHM = "AES";

    public static String encrypt(String input) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedBytes = cipher.doFinal(input.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            log.error("Encryption failed: {}", e.getMessage());
            throw new EncryptDecryptException("Encryption failed "+"\n"+ e.getMessage());
        }
    }

    public static String decrypt(String input) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decryptedBytes = cipher.doFinal(input.getBytes());
            return Base64.getDecoder().decode(decryptedBytes).toString();
        } catch (Exception e) {
            log.error("Decryption failed: {}", e.getMessage());
            throw new EncryptDecryptException("Decryption failed "+"\n"+ e.getMessage());
        }
    }
}
