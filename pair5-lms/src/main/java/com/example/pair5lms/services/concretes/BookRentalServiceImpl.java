package com.example.pair5lms.services.concretes;

import com.example.pair5lms.core.utils.exception.types.BusinessException;
import com.example.pair5lms.entities.BookRental;
import com.example.pair5lms.entities.BookRentalDetail;
import com.example.pair5lms.entities.User;
import com.example.pair5lms.repositories.BookRentalRepository;
import com.example.pair5lms.services.abstracts.*;
import com.example.pair5lms.services.dtos.requests.bookrental.AddBookRentalRequest;
import com.example.pair5lms.services.dtos.requests.bookrental.UpdateBookRentalRequest;
import com.example.pair5lms.services.dtos.requests.bookrentaldetail.AddBookRentalDetailRequest;
import com.example.pair5lms.services.dtos.responses.booklocation.GetBookLocationResponse;
import com.example.pair5lms.services.dtos.responses.bookrental.*;
import com.example.pair5lms.services.dtos.responses.bookrentaldetail.GetBookRentalDetailResponse;
import com.example.pair5lms.services.dtos.responses.user.GetUserResponse;
import com.example.pair5lms.services.mappers.BookRentalMapper;
import com.example.pair5lms.services.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class BookRentalServiceImpl implements BookRentalService {
    private BookRentalRepository bookRentalRepository;
    private UserService userService;
    private BookRentalDetailService bookRentalDetailService;
    private BookLocationService bookLocationService;
    private BookService bookService;

    @Override
    public AddBookRentalResponse add(AddBookRentalRequest request) {
        BookRental bookRental = BookRentalMapper.INSTANCE.bookRentalFromAddRequest(request);
        double totalRentalCost = 0;

        GetUserResponse getUserResponse = userService.getById(request.getUserId());
        User user = UserMapper.INSTANCE.userFromGetUserResponse(getUserResponse);
        bookRental.setUser(user);

        bookRental = bookRentalRepository.save(bookRental);

        List<AddBookRentalDetailRequest> bookRentalDetailRequests = request.getAddBookRentalDetailRequests();
        List<BookRentalDetail> bookRentalDetails = new ArrayList<>();

        for (AddBookRentalDetailRequest addBookRentalDetailRequest : bookRentalDetailRequests) {
            double bookPrice = bookService.getBookPriceFromId(addBookRentalDetailRequest.getBookId());
            addBookRentalDetailRequest.setBookRentalId(bookRental.getId());
            addBookRentalDetailRequest.setBookPrice(bookPrice);
            BookRentalDetail bookRentalDetail = bookRentalDetailService.addRequestFromRental(addBookRentalDetailRequest);
            bookRentalDetails.add(bookRentalDetail);
            totalRentalCost += bookPrice;
        }

        bookRental.setTotalRentalCost(totalRentalCost);

        AddBookRentalResponse addBookRentalResponse = BookRentalMapper.INSTANCE.addResponseFromBookRental(bookRental);
        addBookRentalResponse.setBookRentalDetails(bookRentalDetails);
        bookRental = bookRentalRepository.save(bookRental);

        return addBookRentalResponse;
    }

    @Override
    public UpdateBookRentalResponse update(UpdateBookRentalRequest request) {
        BookRental bookRental = BookRentalMapper.INSTANCE.bookRentalFromUpdateRequest(request);
        BookRental oldBookRental = bookRentalRepository.findById(request.getId()).orElseThrow(() -> new BusinessException("Invalid Book Rental Id"));
        bookRental.setTotalRentalCost(oldBookRental.getTotalRentalCost());

        List<GetBookLocationResponse> getBookLocationsResponse = new ArrayList<>();

        GetUserResponse getUserResponse = userService.getById(bookRental.getUser().getId());
        User user = UserMapper.INSTANCE.userFromGetUserResponse(getUserResponse);
        bookRental.setUser(user);

        for (int idToReturn : request.getBookLocationIdsToReturn()) {
            GetBookLocationResponse getBookLocationResponse = bookLocationService.returnBookLocation(idToReturn);
            getBookLocationsResponse.add(getBookLocationResponse);
            GetBookRentalDetailResponse getBookRentalDetailResponse = bookRentalDetailService.bookToReturn(request.getId(), idToReturn);

            double penaltyPrice = bookRentalDetailService.calculatePenalty(request.getId(), idToReturn);

            if (penaltyPrice > 0) {
                bookRental.setTotalRentalCost(bookRental.getTotalRentalCost() + penaltyPrice);
            }
        }

        bookRental.setAllBookReturned(bookRentalDetailService.isAllBookReturned(bookRental.getId()));
        bookRental = bookRentalRepository.save(bookRental);

        UpdateBookRentalResponse updateBookRentalResponse = BookRentalMapper.INSTANCE.updateResponseFromBookRental(bookRental);
        updateBookRentalResponse.setReturnedBooks(getBookLocationsResponse);

        return updateBookRentalResponse;
    }

    @Override
    public DeleteBookRentalResponse delete(int id) {
        BookRental bookRental = bookRentalRepository.findById(id).orElseThrow();

        GetUserResponse getUserResponse = userService.getById(bookRental.getUser().getId());
        User user = UserMapper.INSTANCE.userFromGetUserResponse(getUserResponse);
        bookRental.setUser(user);

        DeleteBookRentalResponse deleteBookRentalResponse = BookRentalMapper.INSTANCE.deleteResponseFromId(bookRental);
        bookRentalRepository.delete(bookRental);

        return deleteBookRentalResponse;
    }

    @Override
    public List<ListBookRentalResponse> getAll() {
        List<BookRental> bookRentals = bookRentalRepository.findAll();

        for (BookRental bookRental : bookRentals) {
            GetUserResponse getUserResponse = userService.getById(bookRental.getUser().getId());
            User user = UserMapper.INSTANCE.userFromGetUserResponse(getUserResponse);
            bookRental.setUser(user);
        }

        List<ListBookRentalResponse> listBookRentalResponse = BookRentalMapper.INSTANCE.listBookRentalResponse(bookRentals);

        return listBookRentalResponse;
    }

    @Override
    public GetBookRentalResponse getById(int id) {
        BookRental bookRental = bookRentalRepository.findById(id).orElseThrow();
        GetBookRentalResponse getBookRentalResponse = BookRentalMapper.INSTANCE.getResponseFromId(bookRental);

        return getBookRentalResponse;
    }

//    private boolean isBookAvailableForBorrow(int bookId) {
//        List<BookLocation> bookLocations = bookLocationService.findByBookId(bookId);
//        boolean canBookBorrowed = false;
//
//        for (BookLocation bookLocation : bookLocations) {
//            if (bookLocation.isAvailable()) {
//                canBookBorrowed = true;
//                break;
//            }
//        }
//
//        return canBookBorrowed;
//    }
}
