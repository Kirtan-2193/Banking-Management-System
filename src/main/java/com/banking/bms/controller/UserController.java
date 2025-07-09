package com.banking.bms.controller;

import com.banking.bms.model.UserModel;
import com.banking.bms.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserModel> addUser(@RequestBody UserModel userModel) {
        return ResponseEntity.ok(userService.insertUser(userModel));
    }

    @PostMapping("/login")
    public String login(@RequestBody UserModel userModel) {
        return userService.verifyUser(userModel);
    }


    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUser(@RequestParam(required = false) String search) {
        return ResponseEntity.ok(userService.getAllUser(search));
    }

    @PutMapping
    public ResponseEntity<UserModel> editUser(@RequestBody UserModel userModel, @RequestParam String userId) {
        return ResponseEntity.ok(userService.updateUser(userModel, userId));
    }
}
