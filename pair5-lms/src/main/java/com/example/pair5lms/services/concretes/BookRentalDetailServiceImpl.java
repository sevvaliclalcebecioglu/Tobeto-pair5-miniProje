package com.example.pair5lms.services.concretes;

import com.example.pair5lms.repositories.BookRentalDetailRepository;
import com.example.pair5lms.services.abstracts.BookRentalDetailService;
import com.example.pair5lms.services.dtos.requests.bookrentaldetail.AddBookRentalDetailRequest;
import com.example.pair5lms.services.dtos.requests.bookrentaldetail.UpdateBookRentalDetailRequest;
import com.example.pair5lms.services.dtos.responses.bookrentaldetail.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookRentalDetailServiceImpl implements BookRentalDetailService {

    private BookRentalDetailRepository bookRentalDetailRepository;

    @Override
    public AddBookRentalDetailResponse add(AddBookRentalDetailRequest request) {
        return null;
    }

    @Override
    public UpdateBookRentalDetailResponse update(UpdateBookRentalDetailRequest request) {
        return null;
    }

    @Override
    public DeleteBookRentalDetailResponse delete(int id) {
        return null;
    }

    @Override
    public List<ListBookRentalDetailResponse> getAll() {
        return null;
    }

    @Override
    public GetBookRentalDetailResponse getById(int id) {
        return null;
    }
}
