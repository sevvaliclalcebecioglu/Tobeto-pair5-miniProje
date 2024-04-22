package com.example.pair5lms.services.dtos.requests.bookrental;

import com.example.pair5lms.services.dtos.requests.bookrentaldetail.AddBookRentalDetailRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBookRentalRequest {
    @NotNull(message = "You must enter a user id.")
    private int userId;

    private List<AddBookRentalDetailRequest> addBookRentalDetailRequests;

}
