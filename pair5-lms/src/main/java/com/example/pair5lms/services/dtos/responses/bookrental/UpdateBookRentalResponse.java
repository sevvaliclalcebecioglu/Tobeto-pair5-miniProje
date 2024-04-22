package com.example.pair5lms.services.dtos.responses.bookrental;

import com.example.pair5lms.services.dtos.responses.booklocation.GetBookLocationResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookRentalResponse {
    private int id;
    private String userName;
    private double totalRentalCost;
    private List<GetBookLocationResponse> returnedBooks;
    private boolean isAllBookReturned;
}
