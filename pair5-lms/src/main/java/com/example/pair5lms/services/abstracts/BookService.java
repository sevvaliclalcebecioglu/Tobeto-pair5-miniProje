package com.example.pair5lms.services.abstracts;

import com.example.pair5lms.services.dtos.requests.book.AddBookRequest;
import com.example.pair5lms.services.dtos.requests.book.UpdateBookRequest;
import com.example.pair5lms.services.dtos.responses.book.*;

import java.util.List;

public interface BookService {
    AddBookResponse add(AddBookRequest request);
    UpdateBookResponse update(UpdateBookRequest request);
    DeleteBookResponse delete(int id);
    List<ListBookResponse> getAll();
    GetBookResponse getById(int id);
    double getBookPriceFromId(int id);

}
