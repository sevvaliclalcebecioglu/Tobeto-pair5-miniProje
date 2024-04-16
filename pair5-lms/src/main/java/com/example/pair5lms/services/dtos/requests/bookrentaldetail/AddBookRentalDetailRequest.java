package com.example.pair5lms.services.dtos.requests.bookrentaldetail;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddBookRentalDetailRequest {
    private LocalDateTime rentalStartDate;

    private LocalDateTime rentalEndDate;

    private LocalDateTime rentalReturnDate;

    private boolean isReturned;
}
