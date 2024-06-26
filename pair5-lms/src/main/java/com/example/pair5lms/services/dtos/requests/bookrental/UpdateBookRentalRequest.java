package com.example.pair5lms.services.dtos.requests.bookrental;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookRentalRequest {
    @NotNull(message = "You must enter an id.")
    private int id;

    @NotNull(message = "You must enter a user id.")
    private int userId;

    @NotNull(message = "Allowed input: 'true' or 'false'")
    private boolean isAllBookReturned;

    private List<Integer> bookLocationIdsToReturn;
}
