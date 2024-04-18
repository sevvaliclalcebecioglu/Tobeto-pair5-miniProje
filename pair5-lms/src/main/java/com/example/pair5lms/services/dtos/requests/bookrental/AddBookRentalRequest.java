package com.example.pair5lms.services.dtos.requests.bookrental;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AddBookRentalRequest {
    @NotNull(message = "You must enter a user id.")
    private int userId;

    @NotNull(message = "Allowed input: 'true' or 'false'")
    private boolean isAllBookReturned;

    @Positive(message = "Total Rental Cost must be higher than 0.")
    private double totalRentalCost;
}
