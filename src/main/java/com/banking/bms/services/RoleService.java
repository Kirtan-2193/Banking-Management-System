package com.banking.bms.services;

import com.banking.bms.mappers.RoleMapper;
import com.banking.bms.model.RoleModel;
import com.banking.bms.model.entities.Role;
import com.banking.bms.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;


    public List<RoleModel> getAllRoles() {
        List<Role> roles = roleRepository.findAll();

        return roleMapper.roleListToRoleModelList(roles);
    }
}
