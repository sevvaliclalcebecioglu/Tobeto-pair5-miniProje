package com.example.pair5lms.services.dtos.responses.user;

import lombok.Data;


@Data
public class GetUserResponse {
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;
}
