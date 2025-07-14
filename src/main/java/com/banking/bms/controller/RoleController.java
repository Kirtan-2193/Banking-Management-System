package com.banking.bms.controller;

import com.banking.bms.model.RoleModel;
import com.banking.bms.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;


    @GetMapping
    @PreAuthorize("@authService.hassPermission(T(com.banking.bms.enumerations.PermissionEnum).VIEW_ROLE)")
    public ResponseEntity<List<RoleModel>> getAllRole() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }
}
