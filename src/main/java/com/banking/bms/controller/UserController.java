package com.banking.bms.controller;

import com.banking.bms.model.MessageModel;
import com.banking.bms.model.UserModel;
import com.banking.bms.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @PreAuthorize("@authService.hassPermission(T(com.banking.bms.enumerations.PermissionEnum).REGISTER_USER)")
    public ResponseEntity<UserModel> addUser(@RequestBody UserModel userModel) {
        return ResponseEntity.ok(userService.insertUser(userModel));
    }

    @PostMapping("/login")
    public String login(@RequestBody UserModel userModel) {
        return userService.verifyUser(userModel);
    }


    @GetMapping("/search")
    @PreAuthorize("@authService.hassPermission(T(com.banking.bms.enumerations.PermissionEnum).VIEW_USER)")
    public ResponseEntity<List<UserModel>> getAllUser(@RequestParam(required = false) String search) {
        return ResponseEntity.ok(userService.getAllUser(search));
    }

    @PutMapping("/update")
    @PreAuthorize("@authService.hassPermission(T(com.banking.bms.enumerations.PermissionEnum).UPDATE_USER)")
    public ResponseEntity<UserModel> editUser(@RequestBody UserModel userModel, @RequestParam String userId) {
        return ResponseEntity.ok(userService.updateUser(userModel, userId));
    }

    @PutMapping("/delete-user")
    @PreAuthorize("@authService.hassPermission(T(com.banking.bms.enumerations.PermissionEnum).DELETE_USER)")
    public ResponseEntity<MessageModel> deleteUser(@RequestParam String userId) {
        return ResponseEntity.ok(userService.deleteUser(userId));
    }
}
