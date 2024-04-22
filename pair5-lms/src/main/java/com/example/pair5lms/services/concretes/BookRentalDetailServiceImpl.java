package com.example.pair5lms.services.concretes;

import com.example.pair5lms.core.utils.exception.types.BusinessException;
import com.example.pair5lms.entities.BookLocation;
import com.example.pair5lms.entities.BookRentalDetail;
import com.example.pair5lms.repositories.BookRentalDetailRepository;
import com.example.pair5lms.services.abstracts.BookLocationService;
import com.example.pair5lms.services.abstracts.BookRentalDetailService;
import com.example.pair5lms.services.dtos.requests.booklocation.UpdateBookLocationRequest;
import com.example.pair5lms.services.dtos.requests.bookrentaldetail.AddBookRentalDetailRequest;
import com.example.pair5lms.services.dtos.requests.bookrentaldetail.UpdateBookRentalDetailRequest;
import com.example.pair5lms.services.dtos.responses.bookrentaldetail.*;
import com.example.pair5lms.services.mappers.BookLocationMapper;
import com.example.pair5lms.services.mappers.BookRentalDetailMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Service
@AllArgsConstructor
public class BookRentalDetailServiceImpl implements BookRentalDetailService {
    public static final double PENALTY_PER_DAY = 0.75;
    private BookRentalDetailRepository bookRentalDetailRepository;
    private BookLocationService bookLocationService;

    @Override
    public AddBookRentalDetailResponse add(AddBookRentalDetailRequest request) {
        BookRentalDetail bookRentalDetail = BookRentalDetailMapper.INSTANCE.bookRentalDetailFromAddRequest(request);
        BookLocation bookLocation = bookToBorrow(request.getBookId());
        bookRentalDetail.setBookLocation(bookLocation);
        bookRentalDetail.setRentalStartDate(LocalDateTime.now());
        bookRentalDetail.setRentalEndDate(LocalDateTime.now().plusMonths(1));
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

    private BookLocation bookToBorrow(int id) {
        List<BookLocation> bookLocations = bookLocationService.findByBookId(id);
        String bookName = bookLocationService.getById(id).getBookName();

        for (BookLocation bookLocation : bookLocations) {
            if (bookLocation.isAvailable()) {
                bookLocation.setAvailable(false);
                UpdateBookLocationRequest updateBookLocationRequest = BookLocationMapper.INSTANCE.updateRequestFromBookLocation(bookLocation);
                bookLocationService.update(updateBookLocationRequest);

                return bookLocation;
            }
        }

        throw new BusinessException(bookName + " is out of stock.");
    }

    public boolean isAllBookReturned(int bookRentalId) {
        List<BookRentalDetail> bookRentalDetails = bookRentalDetailRepository.findAllByBookRentalId(bookRentalId);

        for (BookRentalDetail bookRentalDetail : bookRentalDetails) {
            if (!bookRentalDetail.isReturned()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public GetBookRentalDetailResponse bookToReturn(int rentalId, int bookLocationId) {
        BookRentalDetail bookRentalDetail = bookRentalDetailRepository.findByBookRentalIdAndBookLocationId(rentalId, bookLocationId);
        bookRentalDetail.setRentalReturnDate(LocalDateTime.now().plusMonths(3));
        bookRentalDetail.setReturned(true);
        bookRentalDetailRepository.save(bookRentalDetail);

        return BookRentalDetailMapper.INSTANCE.getBookRentalDetailResponseFromBookRentalDetail(bookRentalDetail);
    }

    @Override
    public BookRentalDetail addRequestFromRental(AddBookRentalDetailRequest addBookRentalDetailRequest) {
        AddBookRentalDetailResponse response = add(addBookRentalDetailRequest);
        BookRentalDetail bookRentalDetail = BookRentalDetailMapper.INSTANCE.bookRentalDetaiLFromAddResponse(response);
        return bookRentalDetail;
    }

    @Override
    public double calculatePenalty(int rentalId, int bookLocationId) {
        BookRentalDetail bookRentalDetail = bookRentalDetailRepository.findByBookRentalIdAndBookLocationId(rentalId, bookLocationId);
        LocalDateTime returnDate = bookRentalDetail.getRentalReturnDate();
        LocalDateTime endDate = bookRentalDetail.getRentalEndDate();
        Long dateDifference = Math.max(0, ChronoUnit.DAYS.between(endDate, returnDate));

        return dateDifference * PENALTY_PER_DAY;
    }
}
