package com.example.pair5lms.services.concretes;

import com.example.pair5lms.entities.BookRentalDetail;
import com.example.pair5lms.repositories.BookRentalDetailRepository;
import com.example.pair5lms.services.abstracts.BookRentalDetailService;
import com.example.pair5lms.services.dtos.requests.bookrentaldetail.AddBookRentalDetailRequest;
import com.example.pair5lms.services.dtos.requests.bookrentaldetail.UpdateBookRentalDetailRequest;
import com.example.pair5lms.services.dtos.responses.bookrentaldetail.*;
import com.example.pair5lms.services.mappers.BookRentalDetailMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookRentalDetailServiceImpl implements BookRentalDetailService {
    private BookRentalDetailRepository bookRentalDetailRepository;

    @Override
    public AddBookRentalDetailResponse add(AddBookRentalDetailRequest request) {
        BookRentalDetail bookRentalDetail = BookRentalDetailMapper.INSTANCE.bookRentalDetailFromAddRequest(request);
        bookRentalDetail = bookRentalDetailRepository.save(bookRentalDetail);

        AddBookRentalDetailResponse addBookRentalDetailResponse = BookRentalDetailMapper.INSTANCE.addResponseFromBookRentalDetail(bookRentalDetail);

        return addBookRentalDetailResponse;
    }

    @Override
    public UpdateBookRentalDetailResponse update(UpdateBookRentalDetailRequest request) {
        BookRentalDetail bookRentalDetail = BookRentalDetailMapper.INSTANCE.bookRentalDetailFromUpdateRequest(request);
        bookRentalDetail = bookRentalDetailRepository.save(bookRentalDetail);

        UpdateBookRentalDetailResponse updateBookRentalDetailResponse = BookRentalDetailMapper.INSTANCE.updateResponseFromBookRentalDetail(bookRentalDetail);

        return updateBookRentalDetailResponse;
    }

    @Override
    public DeleteBookRentalDetailResponse delete(int id) {
        BookRentalDetail bookRentalDetail = bookRentalDetailRepository.findById(id).orElseThrow();

        DeleteBookRentalDetailResponse deleteBookRentalDetailResponse = BookRentalDetailMapper.INSTANCE.deleteResponseFromId(bookRentalDetail);

        bookRentalDetailRepository.delete(bookRentalDetail);

        return deleteBookRentalDetailResponse;
    }

    @Override
    public List<ListBookRentalDetailResponse> getAll() {
        List<BookRentalDetail> bookRentalDetails = bookRentalDetailRepository.findAll();
        List<ListBookRentalDetailResponse> bookRentalDetailResponses = BookRentalDetailMapper.INSTANCE.listResponseFromBookRentalDetails(bookRentalDetails);

        return bookRentalDetailResponses;
    }

    @Override
    public GetBookRentalDetailResponse getById(int id) {
        BookRentalDetail bookRentalDetail = bookRentalDetailRepository.findById(id).orElseThrow();
        GetBookRentalDetailResponse getBookRentalDetailResponse = BookRentalDetailMapper.INSTANCE.getBookRentalDetailResponseFromBookRentalDetail(bookRentalDetail);

        return getBookRentalDetailResponse;
    }
}
