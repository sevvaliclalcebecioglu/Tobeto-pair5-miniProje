package com.example.pair5lms.services.abstracts;


import com.example.pair5lms.entities.BookRentalDetail;
import com.example.pair5lms.services.dtos.requests.bookrentaldetail.AddBookRentalDetailRequest;
import com.example.pair5lms.services.dtos.requests.bookrentaldetail.UpdateBookRentalDetailRequest;
import com.example.pair5lms.services.dtos.responses.bookrentaldetail.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

public interface BookRentalDetailService {
    AddBookRentalDetailResponse add(AddBookRentalDetailRequest request);
    UpdateBookRentalDetailResponse update(UpdateBookRentalDetailRequest request);
    DeleteBookRentalDetailResponse delete(int id);
    List<ListBookRentalDetailResponse> getAll();
    GetBookRentalDetailResponse getById(int id);
    boolean isAllBookReturned(int bookRentalId);
    GetBookRentalDetailResponse bookToReturn(int rentalId, int bookLocationId);
    BookRentalDetail addRequestFromRental(AddBookRentalDetailRequest addBookRentalDetailRequest);
    double calculatePenalty(int rentalId, int bookLocationId);
}
