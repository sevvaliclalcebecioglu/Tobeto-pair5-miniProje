package com.example.pair5lms.services.dtos.requests.booklocation;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddBookLocationRequest {
    @NotNull(message = "You must enter an id.")
    private int bookId;

    @NotNull(message = "Allowed input: 'true' or 'false'")
    private boolean isAvailable;

    private LocalDateTime addedDate;
}
