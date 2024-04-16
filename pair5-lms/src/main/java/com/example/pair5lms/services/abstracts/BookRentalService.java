package com.example.pair5lms.services.abstracts;

import com.example.pair5lms.services.dtos.requests.bookrental.AddBookRentalRequest;
import com.example.pair5lms.services.dtos.requests.bookrental.UpdateBookRentalRequest;
import com.example.pair5lms.services.dtos.responses.bookrental.*;

import java.util.List;

public interface BookRentalService {
    AddBookRentalResponse add(AddBookRentalRequest request);
    UpdateBookRentalResponse update(UpdateBookRentalRequest request);
    DeleteBookRentalResponse delete(int id);
    List<ListBookRentalResponse> getAll();
    GetBookRentalResponse getById(int id);
}
