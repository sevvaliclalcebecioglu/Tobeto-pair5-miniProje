package com.example.pair5lms.services.dtos.requests.book;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateBookRequest {
    @NotNull(message = "You must enter an id.")
    private int id;

    @Positive(message = "Isbn must be higher than 0.")
    private int isbn;

    @NotEmpty(message = "Book name connot be empty.")
    @Size(min = 2 ,max = 255 , message = "Book name must be between 2-255 characters.")
    private String name;

    @Positive(message = "Page must be higher than 0.")
    private int page;

}
