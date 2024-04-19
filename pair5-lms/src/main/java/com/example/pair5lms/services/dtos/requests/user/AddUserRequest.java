package com.example.pair5lms.services.dtos.requests.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {
    @NotEmpty(message = "First name cannot be empty.")
    @Size(min = 2, max = 32, message = "First Name must be between 2-32 characters.")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty.")
    @Size(min = 2, max = 32, message = "Last Name must be between 2-32 characters.")
    private String lastName;

    @NotEmpty(message = "Email cannot be empty.")
    @Email(message = "You must enter a valid email.")
    @Size(max = 100, message = "Email must be maximum 100 characters.")
    private String email;

    @NotEmpty(message = "Password cannot be empty.")
    @Size(min = 8, max = 32, message = "Password must be between 8-32 characters.")
    private String password;
}
