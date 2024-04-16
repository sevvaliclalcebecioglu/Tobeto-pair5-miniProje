package com.example.pair5lms.services.concretes;

import com.example.pair5lms.repositories.BookRentalRepository;
import com.example.pair5lms.services.abstracts.BookRentalService;
import com.example.pair5lms.services.dtos.requests.bookrental.AddBookRentalRequest;
import com.example.pair5lms.services.dtos.requests.bookrental.UpdateBookRentalRequest;
import com.example.pair5lms.services.dtos.responses.bookrental.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookRentalServiceImpl implements BookRentalService {

    private BookRentalRepository bookRentalRepository;

    @Override
    public AddBookRentalResponse add(AddBookRentalRequest request) {
        return null;
    }

    @Override
    public UpdateBookRentalResponse update(UpdateBookRentalRequest request) {
        return null;
    }

    @Override
    public DeleteBookRentalResponse delete(int id) {
        return null;
    }

    @Override
    public List<ListBookRentalResponse> getAll() {
        return null;
    }

    @Override
    public GetBookRentalResponse getById(int id) {
        return null;
    }
}
