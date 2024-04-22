package com.example.pair5lms.services.concretes;


import com.example.pair5lms.core.utils.exception.types.BusinessException;
import com.example.pair5lms.entities.Book;
import com.example.pair5lms.entities.BookLocation;
import com.example.pair5lms.repositories.BookLocationRepository;
import com.example.pair5lms.services.abstracts.BookLocationService;
import com.example.pair5lms.services.abstracts.BookService;
import com.example.pair5lms.services.dtos.requests.booklocation.AddBookLocationRequest;
import com.example.pair5lms.services.dtos.requests.booklocation.UpdateBookLocationRequest;
import com.example.pair5lms.services.dtos.responses.book.GetBookResponse;
import com.example.pair5lms.services.dtos.responses.booklocation.*;
import com.example.pair5lms.services.mappers.BookLocationMapper;
import com.example.pair5lms.services.mappers.BookMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookLocationServiceImpl implements BookLocationService {
    private BookLocationRepository bookLocationRepository;
    private BookService bookService;

    @Override
    public AddBookLocationResponse add(AddBookLocationRequest request) {
        BookLocation bookLocation = BookLocationMapper.INSTANCE.bookLocationFromAddRequest(request);
        GetBookResponse getBookResponse = bookService.getById(bookLocation.getBook().getId());
        Book book = BookMapper.INSTANCE.bookFromGetResponse(getBookResponse);
        bookLocation.setBook(book);
        bookLocation = bookLocationRepository.save(bookLocation);

        AddBookLocationResponse addBookLocationResponse = BookLocationMapper.INSTANCE.addResponseFromBookLocation(bookLocation);

        return addBookLocationResponse;
    }

    @Override
    public UpdateBookLocationResponse update(UpdateBookLocationRequest request) {
        BookLocation bookLocation = BookLocationMapper.INSTANCE.bookLocationFromUpdateRequest(request);
        GetBookResponse getBookResponse = bookService.getById(bookLocation.getBook().getId());
        Book book = BookMapper.INSTANCE.bookFromGetResponse(getBookResponse);
        bookLocation.setBook(book);
        bookLocation = bookLocationRepository.save(bookLocation);

        UpdateBookLocationResponse updateBookLocationResponse = BookLocationMapper.INSTANCE.updateResponseFromBookLocation(bookLocation);

        return updateBookLocationResponse;
    }

    @Override
    public DeleteBookLocationResponse delete(int id) {
        BookLocation bookLocation = bookLocationRepository.findById(id).orElseThrow();
        GetBookResponse getBookResponse = bookService.getById(bookLocation.getBook().getId());
        Book book = BookMapper.INSTANCE.bookFromGetResponse(getBookResponse);
        bookLocation.setBook(book);
        DeleteBookLocationResponse deleteBookLocationResponse = BookLocationMapper.INSTANCE.deleteResponseFromId(bookLocation, book);
        bookLocationRepository.delete(bookLocation);

        return deleteBookLocationResponse;
    }

    @Override
    public List<ListBookLocationResponse> getAll() {
        List<BookLocation> bookLocations = bookLocationRepository.findAll();
        List<ListBookLocationResponse> listBookLocationResponse = BookLocationMapper.INSTANCE.listBookLocationResponse(bookLocations);

        return listBookLocationResponse;
    }

    @Override
    public GetBookLocationResponse getById(int id) {
        BookLocation bookLocation = bookLocationRepository.findById(id).orElseThrow(() -> new BusinessException("Invalid Book Location Id"));
        GetBookResponse getBookResponse = bookService.getById(bookLocation.getBook().getId());
        Book book = BookMapper.INSTANCE.bookFromGetResponse(getBookResponse);
        bookLocation.setBook(book);
        GetBookLocationResponse getBookLocationResponse = BookLocationMapper.INSTANCE.getResponseFromId(bookLocation);

        return getBookLocationResponse;
    }

    @Override
    public List<BookLocation> findByBookId(int id) {
        return bookLocationRepository.findByBookId(id);
    }

    public GetBookLocationResponse returnBookLocation(int id) {
        BookLocation bookLocation = bookLocationRepository.findById(id).orElseThrow(() -> new BusinessException("Invalid Book Location Id"));
        bookLocation.setAvailable(true);
        bookLocation = bookLocationRepository.save(bookLocation);
        GetBookLocationResponse getBookLocationResponse = BookLocationMapper.INSTANCE.getResponseFromId(bookLocation);

        return getBookLocationResponse;
    }
}
