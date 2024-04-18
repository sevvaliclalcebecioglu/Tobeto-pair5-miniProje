package com.example.pair5lms.services.concretes;

import com.example.pair5lms.entities.Book;
import com.example.pair5lms.entities.BookRental;
import com.example.pair5lms.entities.User;
import com.example.pair5lms.repositories.BookRentalDetailRepository;
import com.example.pair5lms.repositories.BookRentalRepository;
import com.example.pair5lms.repositories.UserRepository;
import com.example.pair5lms.services.abstracts.BookRentalService;
import com.example.pair5lms.services.dtos.requests.bookrental.AddBookRentalRequest;
import com.example.pair5lms.services.dtos.requests.bookrental.UpdateBookRentalRequest;
import com.example.pair5lms.services.dtos.responses.bookrental.*;
import com.example.pair5lms.services.mappers.BookRentalMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookRentalServiceImpl implements BookRentalService {
    private BookRentalRepository bookRentalRepository;
    private UserRepository userRepository;

    @Override
    public AddBookRentalResponse add(AddBookRentalRequest request) {
        BookRental bookRental = BookRentalMapper.INSTANCE.bookRentalFromAddRequest(request);
        bookRental = bookRentalRepository.save(bookRental);
        User user = userRepository.findById(bookRental.getUser().getId()).orElseThrow();

        AddBookRentalResponse addBookRentalResponse = BookRentalMapper.INSTANCE.addResponseFromBookRental(bookRental, user);

        return addBookRentalResponse;
    }

    @Override
    public UpdateBookRentalResponse update(UpdateBookRentalRequest request) {
        BookRental bookRental = BookRentalMapper.INSTANCE.bookRentalFromUpdateRequest(request);
        bookRental = bookRentalRepository.save(bookRental);
        User user = userRepository.findById(bookRental.getUser().getId()).orElseThrow();

        UpdateBookRentalResponse updateBookRentalResponse = BookRentalMapper.INSTANCE.updateResponseFromBookRental(bookRental, user);

        return updateBookRentalResponse;
    }

    @Override
    public DeleteBookRentalResponse delete(int id) {
        BookRental bookRental = bookRentalRepository.findById(id).orElseThrow();
        User user = userRepository.findById(bookRental.getUser().getId()).orElseThrow();
        DeleteBookRentalResponse deleteBookRentalResponse = BookRentalMapper.INSTANCE.deleteResponseFromId(bookRental, user);
        bookRentalRepository.delete(bookRental);

        return deleteBookRentalResponse;
    }

    @Override
    public List<ListBookRentalResponse> getAll() {
        List<BookRental> bookRentals = bookRentalRepository.findAll();
        List<ListBookRentalResponse> listBookRentalResponse = BookRentalMapper.INSTANCE.listBookRentalResponse(bookRentals);

        return listBookRentalResponse;
    }

    @Override
    public GetBookRentalResponse getById(int id) {
        BookRental bookRental = bookRentalRepository.findById(id).orElseThrow();
        GetBookRentalResponse getBookRentalResponse = BookRentalMapper.INSTANCE.getResponseFromId(bookRental);

        return getBookRentalResponse;
    }
}
