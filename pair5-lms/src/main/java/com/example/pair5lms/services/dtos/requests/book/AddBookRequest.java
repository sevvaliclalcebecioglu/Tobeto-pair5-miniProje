package com.example.pair5lms.services.dtos.requests.book;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBookRequest {
    @Positive(message = "Isbn must be higher than 0.")
    private int isbn;

    @NotEmpty(message = "Book name cannot be empty.")
    @Size(min = 2, max = 255, message = "Book name must be between 2-255 characters.")
    private String name;

    @Size(min = 2, max = 32, message = "Author Name must be between 2-32 characters.")
    @Size(min = 2, max = 255, message = "Book name must be between 2-255 characters.")
    private String author;

    @Positive(message = "Page must be higher than 0.")
    private int page;

    @Positive(message = "Price must be higher than 0.")
    private double price;
}
