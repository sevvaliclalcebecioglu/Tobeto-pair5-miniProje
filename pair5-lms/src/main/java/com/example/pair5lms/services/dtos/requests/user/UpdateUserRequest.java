package com.example.pair5lms.services.dtos.requests.user;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;
}
