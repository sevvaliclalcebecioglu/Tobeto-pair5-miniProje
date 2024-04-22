package com.example.pair5lms.services.dtos.responses.bookrental;

import com.example.pair5lms.entities.BookRentalDetail;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBookRentalResponse {
    private int id;
    private String userName;
    private double totalRentalCost;
    private boolean isAllBookReturned;
    private List<BookRentalDetail> bookRentalDetails;
}
