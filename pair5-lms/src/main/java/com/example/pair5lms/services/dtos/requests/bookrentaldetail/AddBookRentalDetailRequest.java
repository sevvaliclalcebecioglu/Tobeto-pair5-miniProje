package com.example.pair5lms.services.dtos.requests.bookrentaldetail;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBookRentalDetailRequest {

    @NotNull(message = "You must enter a book rental id.")
    private int bookId;

    @Positive(message = "Book Price must be higher than 0.")
    private double bookRentalId;

    private LocalDateTime rentalStartDate;

    @FutureOrPresent
    private LocalDateTime rentalEndDate;

    private LocalDateTime rentalReturnDate;

    @NotNull(message = "Allowed input: 'true' or 'false'")
    private boolean isReturned;
}
