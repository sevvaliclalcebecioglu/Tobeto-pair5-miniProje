package com.example.pair5lms.services.dtos.responses.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteUserResponse {
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;
}
