package com.banking.bms.controller;

import com.banking.bms.services.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/otp")
@RequiredArgsConstructor
public class OtpController {

    private final OtpService otpService;

    @GetMapping("/generate")
    public ResponseEntity<String> generateOtp(@RequestParam String email) {
        otpService.generateOtp(email);

        return ResponseEntity.ok("OTP Send on this Email:- " + email);
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyOtp(@RequestParam String email,
                                            @RequestParam String otp) {
        boolean result = otpService.validateOtp(email, otp);

        return ResponseEntity.ok(result ? "OTP Verified" : "Please enter correct OTP Or OTP was Expired");
    }
}
