package com.example.pair5lms.services.dtos.requests.bookrentaldetail;

import com.example.pair5lms.entities.BookLocation;
import com.example.pair5lms.entities.BookRental;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookRentalDetailRequest {
    @NotNull(message = "You must enter an id.")
    private int id;

    @NotNull(message = "You must enter a book location id.")
    private int bookLocationId;

    @NotNull(message = "You must enter a book rental id.")
    private int bookRentalId;

    @Positive(message = "Book Price must be higher than 0.")
    private double bookPrice;

    private LocalDateTime rentalStartDate;

    @FutureOrPresent
    private LocalDateTime rentalEndDate;

    private LocalDateTime rentalReturnDate;

    @NotNull(message = "Allowed input: 'true' or 'false'")
    private boolean isReturned;
}
