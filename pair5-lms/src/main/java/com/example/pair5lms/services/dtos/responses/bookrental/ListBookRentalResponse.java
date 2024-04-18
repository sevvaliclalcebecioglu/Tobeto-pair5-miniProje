package com.example.pair5lms.services.dtos.responses.bookrental;

import lombok.Data;

@Data
public class ListBookRentalResponse {
    private int id;

    private String userName;

    private double totalRentalCost;

    private boolean isAllBookReturned;
}
