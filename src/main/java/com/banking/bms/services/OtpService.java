package com.banking.bms.services;

import com.banking.bms.model.entities.User;
import com.banking.bms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OtpService {

    private final EmailService emailService;

    private final UserRepository userRepository;

    private record OtpData(String code, LocalDateTime expiryTime) {}

    private final Map<String, OtpData> otpStorage = new HashMap<>();

    public String generateOtp(String email) {
        String otp = String.valueOf(new Random().nextInt(900000) + 100000);
        otpStorage.put(email, new OtpData(otp, LocalDateTime.now().plusMinutes(2)));

        User user = userRepository.findByEmail(email);
        emailService.sendOTPEmail(user, otp);

        return otp;
    }

    public boolean validateOtp(String email, String otp) {
        OtpData otpData = otpStorage.get(email);
        if (otpData == null) {
            return false;
        }
        if (LocalDateTime.now().isAfter(otpData.expiryTime())) {
            otpStorage.remove(email);
            return false;
        }
        return otpData.code().equals(otp);
    }
}
