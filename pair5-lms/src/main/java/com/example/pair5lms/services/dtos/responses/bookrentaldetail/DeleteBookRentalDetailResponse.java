package com.example.pair5lms.services.dtos.responses.bookrentaldetail;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteBookRentalDetailResponse {
    private int id;

    private int bookLocationId;

    private int bookRentalId;

    private double bookPrice;

    private LocalDateTime rentalStartDate;

    private LocalDateTime rentalEndDate;

    private LocalDateTime rentalReturnDate;

    private boolean isReturned;
}
