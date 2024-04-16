package com.example.pair5lms.services.concretes;

import com.example.pair5lms.repositories.UserRepository;
import com.example.pair5lms.services.abstracts.UserService;
import com.example.pair5lms.services.dtos.requests.user.AddUserRequest;
import com.example.pair5lms.services.dtos.requests.user.UpdateUserRequest;
import com.example.pair5lms.services.dtos.responses.user.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public AddUserResponse add(AddUserRequest request) {
        return null;
    }

    @Override
    public UpdateUserResponse update(UpdateUserRequest request) {
        return null;
    }

    @Override
    public DeleteUserResponse delete(int id) {
        return null;
    }

    @Override
    public List<ListUserResponse> getAll() {
        return null;
    }

    @Override
    public GetUserResponse getById(int id) {
        return null;
    }
}
