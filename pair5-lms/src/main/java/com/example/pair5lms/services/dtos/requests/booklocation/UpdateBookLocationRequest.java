package com.example.pair5lms.services.dtos.requests.booklocation;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookLocationRequest {
    @NotNull(message = "You must enter an id.")
    private int id;

    @NotNull(message = "You must enter a book id.")
    private int bookId;

    @NotNull(message = "Allowed input: 'true' or 'false'")
    private boolean isAvailable;

    private LocalDateTime addedDate;
}
