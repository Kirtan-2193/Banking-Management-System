package com.banking.bms.mappers;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import com.banking.bms.model.UserAccountModel;
import com.banking.bms.model.UserModel;
import com.banking.bms.model.entities.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface UserMapper {

    User userModelToUser(UserModel userModel);

    UserModel userToUserModel(User user);

    List<UserModel> userListToUserModelList(List<User> users);

    void updateUserFromUserModel(UserModel userModel, @MappingTarget User user);

    UserAccountModel userToUserAccountModel(User user);

}
