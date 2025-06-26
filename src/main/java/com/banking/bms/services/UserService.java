package com.banking.bms.services;

import com.banking.bms.mappers.RoleMapper;
import com.banking.bms.mappers.UserMapper;
import com.banking.bms.model.RoleModel;
import com.banking.bms.model.UserModel;
import com.banking.bms.model.entities.Role;
import com.banking.bms.model.entities.User;
import com.banking.bms.model.entities.UserRole;
import com.banking.bms.repository.RoleRepository;
import com.banking.bms.repository.UserRepository;
import com.banking.bms.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final RoleRepository roleRepository;

    private final UserRoleRepository userRoleRepository;

    private final RoleMapper roleMapper;



    public UserModel insertUser(UserModel userModel) {

        if (userRepository.existsByEmail(userModel.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = userMapper.userModelToUser(userModel);
        user = userRepository.save(user);

        List<String> roleIdsFromModel = userModel.getRoles().stream().map(r -> r.getRoleId()).toList();
        List<Role> rolesFromEntity = roleRepository.findByRoleIdIn(roleIdsFromModel);
        List<String> roleIdFromEntity = rolesFromEntity.stream().map(r -> r.getRoleId()).toList();
        List<String> invalidRoleId = new ArrayList<>();

        for (String roleIdFromModel : roleIdsFromModel) {
            if (!roleIdFromEntity.contains(roleIdFromModel)) {
                invalidRoleId.add(roleIdFromModel);
            }
        }

        if (!invalidRoleId.isEmpty()) {
            throw new RuntimeException("Invalid role id: " + invalidRoleId);
        }

        List<Role> rolesToSave = rolesFromEntity.stream().filter(r -> roleIdsFromModel.contains(r.getRoleId())).toList();

        for (Role role : rolesToSave) {
            UserRole userRole = new UserRole();
            userRole.setUser(user);
            userRole.setRole(role);
            userRoleRepository.save(userRole);
        }

        UserModel userModelToReturn = userMapper.userToUserModel(user);
        List<UserRole> byUserUserId = userRoleRepository.findByUserUserId(user.getUserId());
        List<RoleModel> roleModels = new ArrayList<>();
        byUserUserId.forEach(ur -> roleModels.add(roleMapper.roleToRoleModel(ur.getRole())));
        userModelToReturn.setRoles(roleModels);

        return userModelToReturn;
    }

    public List<UserModel> getAllUser(String search) {

        List<User> userList = userRepository.findAllUserBy(search);
        List<UserModel> userModelList = userMapper.userListToUserModelList(userList);
        for (UserModel userModel : userModelList) {
            List<UserRole> byUserUserId = userRoleRepository.findByUserUserId(userModel.getUserId());
            List<RoleModel> roleModelList = new ArrayList<>();
            byUserUserId.forEach(ur -> roleModelList.add(roleMapper.roleToRoleModel(ur.getRole())));
            userModel.setRoles(roleModelList);
        }

        return userModelList;
    }
}
