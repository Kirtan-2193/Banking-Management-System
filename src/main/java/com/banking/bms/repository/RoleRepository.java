package com.banking.bms.repository;

import com.banking.bms.model.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, String> {

    List<Role> findByRoleIdIn(List<String> roleIds);
}
