package com.example.pair5lms.services.concretes;

import com.example.pair5lms.repositories.BookLocationRepository;
import com.example.pair5lms.services.abstracts.BookLocationService;
import com.example.pair5lms.services.dtos.requests.booklocation.AddBookLocationRequest;
import com.example.pair5lms.services.dtos.requests.booklocation.UpdateBookLocationRequest;
import com.example.pair5lms.services.dtos.responses.booklocation.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookLocationServiceImpl implements BookLocationService {

    private BookLocationRepository bookLocationRepository;

    @Override
    public AddBookLocationResponse add(AddBookLocationRequest request) {
        return null;
    }

    @Override
    public UpdateBookLocationResponse update(UpdateBookLocationRequest request) {
        return null;
    }

    @Override
    public DeleteBookLocationResponse delete(int id) {
        return null;
    }

    @Override
    public List<ListBookLocationResponse> getAll() {
        return null;
    }

    @Override
    public GetBookLocationResponse getById(int id) {
        return null;
    }
}
