package com.example.pair5lms.services.abstracts;

import com.example.pair5lms.services.dtos.requests.user.AddUserRequest;
import com.example.pair5lms.services.dtos.requests.user.UpdateUserRequest;
import com.example.pair5lms.services.dtos.responses.user.*;

import java.util.List;

public interface UserService {
    AddUserResponse add(AddUserRequest request);
    UpdateUserResponse update(UpdateUserRequest request);
    DeleteUserResponse delete(int id);
    List<ListUserResponse> getAll();
    GetUserResponse getById(int id);
}
