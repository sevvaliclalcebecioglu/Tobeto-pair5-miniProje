package com.example.pair5lms.services.abstracts;

import com.example.pair5lms.services.dtos.requests.booklocation.AddBookLocationRequest;
import com.example.pair5lms.services.dtos.requests.booklocation.UpdateBookLocationRequest;
import com.example.pair5lms.services.dtos.responses.book.ListBookResponse;
import com.example.pair5lms.services.dtos.responses.booklocation.*;

import java.util.List;

public interface BookLocationService {
    AddBookLocationResponse add(AddBookLocationRequest request);
    UpdateBookLocationResponse update(UpdateBookLocationRequest request);
    DeleteBookLocationResponse delete(int id);
    List<ListBookLocationResponse> getAll();
    GetBookLocationResponse getById(int id);

}
