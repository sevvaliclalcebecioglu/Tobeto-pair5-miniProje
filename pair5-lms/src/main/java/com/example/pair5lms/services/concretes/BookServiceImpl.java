package com.example.pair5lms.services.concretes;

import com.example.pair5lms.repositories.BookRepository;
import com.example.pair5lms.services.abstracts.BookService;
import com.example.pair5lms.services.dtos.requests.book.AddBookRequest;
import com.example.pair5lms.services.dtos.requests.book.UpdateBookRequest;
import com.example.pair5lms.services.dtos.responses.book.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Override
    public AddBookResponse add(AddBookRequest request) {
        return null;
    }

    @Override
    public UpdateBookResponse update(UpdateBookRequest request) {
        return null;
    }

    @Override
    public DeleteBookResponse delete(int id) {
        return null;
    }

    @Override
    public List<ListBookResponse> getAll() {
        return null;
    }

    @Override
    public GetBookResponse getById(int id) {
        return null;
    }
}
