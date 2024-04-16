package com.example.pair5lms.services.dtos.requests.user;

import lombok.Data;

@Data
public class AddUserRequest {
    private String firstName;

    private String lastName;

    private String email;

    private String password;

}
