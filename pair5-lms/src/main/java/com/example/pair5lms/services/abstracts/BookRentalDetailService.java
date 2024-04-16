package com.example.pair5lms.services.abstracts;

import com.example.pair5lms.services.dtos.requests.bookrentaldetail.AddBookRentalDetailRequest;
import com.example.pair5lms.services.dtos.requests.bookrentaldetail.UpdateBookRentalDetailRequest;
import com.example.pair5lms.services.dtos.responses.bookrentaldetail.*;

import java.util.List;

public interface BookRentalDetailService {
    AddBookRentalDetailResponse add(AddBookRentalDetailRequest request);
    UpdateBookRentalDetailResponse update(UpdateBookRentalDetailRequest request);
    DeleteBookRentalDetailResponse delete(int id);
    List<ListBookRentalDetailResponse> getAll();
    GetBookRentalDetailResponse getById(int id);
}
