package com.example.pair5lms.services.dtos.requests.bookrental;

import lombok.Data;

@Data
public class UpdateBookRentalRequest {
    private int id;

    private boolean isAllBookReturned;

}
