package com.example.pair5lms.services.dtos.responses.bookrental;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteBookRentalResponse {
    private int id;

    private String userName;

    private double totalRentalCost;

    private boolean isAllBookReturned;
}
