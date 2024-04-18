package com.example.pair5lms.services.mappers;

import com.example.pair5lms.entities.User;
import com.example.pair5lms.services.dtos.requests.user.AddUserRequest;
import com.example.pair5lms.services.dtos.requests.user.UpdateUserRequest;
import com.example.pair5lms.services.dtos.responses.user.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userFromAddRequest(AddUserRequest request);

    AddUserResponse addResponseFromUser(User user);

    User userFromUpdateRequest(UpdateUserRequest request);

    UpdateUserResponse updateResponseFromUser(User user);

    DeleteUserResponse deleteResponseFromId(User user);

    ListUserResponse listUserResponseMap(User user);

    List<ListUserResponse> listUserResponse(List<User> users);

    GetUserResponse getResponseFromId(User user);


}
