package com.example.pair5lms.services.concretes;

import com.example.pair5lms.entities.Book;
import com.example.pair5lms.repositories.BookRepository;
import com.example.pair5lms.services.abstracts.BookService;
import com.example.pair5lms.services.dtos.requests.book.AddBookRequest;
import com.example.pair5lms.services.dtos.requests.book.UpdateBookRequest;
import com.example.pair5lms.services.dtos.responses.book.*;
import com.example.pair5lms.services.mappers.BookMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Override
    public AddBookResponse add(AddBookRequest request) {
        Book book = BookMapper.INSTANCE.bookFromAddRequest(request);
        book = bookRepository.save(book);
        AddBookResponse addBookResponse = BookMapper.INSTANCE.addResponseFromBook(book);

        return addBookResponse;
    }

    @Override
    public UpdateBookResponse update(UpdateBookRequest request) {
        Book book = BookMapper.INSTANCE.bookFromUpdateRequest(request);
        book = bookRepository.save(book);
        UpdateBookResponse updateBookResponse = BookMapper.INSTANCE.updateResponseFromBook(book);

        return updateBookResponse;
    }

    @Override
    public DeleteBookResponse delete(int id) {
        Book book = bookRepository.findById(id).orElseThrow();
        DeleteBookResponse deleteBookResponse = BookMapper.INSTANCE.deleteResponseFromId(book);
        bookRepository.delete(book);
        return deleteBookResponse;
    }

    @Override
    public List<ListBookResponse> getAll() {
        List<Book> books = bookRepository.findAll();
        List<ListBookResponse> listBookResponses = BookMapper.INSTANCE.listBookResponse(books);

        return listBookResponses;
    }

    @Override
    public GetBookResponse getById(int id) {
        Book book = bookRepository.findById(id).orElseThrow();
        GetBookResponse getBookResponse = BookMapper.INSTANCE.getResponseFromId(book);

        return getBookResponse;
    }

    @Override
    public double getBookPriceFromId(int id) {
        return 0;
    }


}
