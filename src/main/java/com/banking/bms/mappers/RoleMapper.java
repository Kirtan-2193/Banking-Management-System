package com.banking.bms.mappers;

import com.banking.bms.model.RoleModel;
import com.banking.bms.model.entities.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);


    RoleModel rolesToRolesModel(Role role);
}
