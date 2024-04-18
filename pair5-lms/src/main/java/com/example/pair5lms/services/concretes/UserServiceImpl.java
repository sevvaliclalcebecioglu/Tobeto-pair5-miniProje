package com.example.pair5lms.services.concretes;

import com.example.pair5lms.entities.User;
import com.example.pair5lms.repositories.UserRepository;
import com.example.pair5lms.services.abstracts.UserService;
import com.example.pair5lms.services.dtos.requests.user.AddUserRequest;
import com.example.pair5lms.services.dtos.requests.user.UpdateUserRequest;
import com.example.pair5lms.services.dtos.responses.user.*;
import com.example.pair5lms.services.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public AddUserResponse add(AddUserRequest request) {
        User user = UserMapper.INSTANCE.userFromAddRequest(request);
        user = userRepository.save(user);

        AddUserResponse addUserResponse = UserMapper.INSTANCE.addResponseFromUser(user);

        return addUserResponse;
    }

    @Override
    public UpdateUserResponse update(UpdateUserRequest request) {
        User user = UserMapper.INSTANCE.userFromUpdateRequest(request);
        user = userRepository.save(user);

        UpdateUserResponse updateUserResponse = UserMapper.INSTANCE.updateResponseFromUser(user);

        return updateUserResponse;
    }

    @Override
    public DeleteUserResponse delete(int id) {
        User user = userRepository.findById(id).orElseThrow();
        DeleteUserResponse deleteUserResponse = UserMapper.INSTANCE.deleteResponseFromId(user);
        userRepository.delete(user);

        return deleteUserResponse;
    }

    @Override
    public List<ListUserResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<ListUserResponse> listUserResponses = UserMapper.INSTANCE.listUserResponse(users);

        return listUserResponses;
    }

    @Override
    public GetUserResponse getById(int id) {
        User user = userRepository.findById(id).orElseThrow();
        GetUserResponse getUserResponse = UserMapper.INSTANCE.getResponseFromId(user);

        return getUserResponse;
    }
}
