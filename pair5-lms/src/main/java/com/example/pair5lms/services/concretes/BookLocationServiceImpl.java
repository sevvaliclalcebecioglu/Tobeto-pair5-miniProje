package com.example.pair5lms.services.concretes;


import com.example.pair5lms.entities.Book;
import com.example.pair5lms.entities.BookLocation;
import com.example.pair5lms.repositories.BookLocationRepository;
import com.example.pair5lms.repositories.BookRepository;
import com.example.pair5lms.services.abstracts.BookLocationService;
import com.example.pair5lms.services.dtos.requests.booklocation.AddBookLocationRequest;
import com.example.pair5lms.services.dtos.requests.booklocation.UpdateBookLocationRequest;
import com.example.pair5lms.services.dtos.responses.book.ListBookResponse;
import com.example.pair5lms.services.dtos.responses.booklocation.*;
import com.example.pair5lms.services.mappers.BookLocationMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookLocationServiceImpl implements BookLocationService {
    private BookLocationRepository bookLocationRepository;
    private BookRepository bookRepository;
    @Override
    public AddBookLocationResponse add(AddBookLocationRequest request) {

        BookLocation bookLocation= BookLocationMapper.INSTANCE.bookLocationFromAddRequest(request);
        Book book=bookRepository.findById(bookLocation.getBook().getId()).orElseThrow();
        // bookWithSameNameShouldNotExist(book.getName());
        bookLocation=bookLocationRepository.save(bookLocation);
        AddBookLocationResponse addBookLocationResponse=BookLocationMapper.INSTANCE.addResponseFromBookLocation(bookLocation,book);

        return addBookLocationResponse;
    }

    @Override
    public UpdateBookLocationResponse update(UpdateBookLocationRequest request) {
        BookLocation bookLocation= BookLocationMapper.INSTANCE.bookLocationFromUpdateRequest(request);
        Book book=bookRepository.findById(bookLocation.getBook().getId()).orElseThrow();
        //bookWithSameNameShouldNotExist(book.getName());
        bookLocation=bookLocationRepository.save(bookLocation);
        UpdateBookLocationResponse updateBookLocationResponse=BookLocationMapper.INSTANCE.updateResponseFromBookLocation(bookLocation,book);

        return updateBookLocationResponse;
    }

    @Override
    public DeleteBookLocationResponse delete(int id) {
        BookLocation bookLocation=bookLocationRepository.findById(id).orElseThrow();
        Book book=bookRepository.findById(bookLocation.getBook().getId()).orElseThrow();
        DeleteBookLocationResponse deleteBookLocationResponse=BookLocationMapper.INSTANCE.deleteResponseFromId(bookLocation);
        bookLocationRepository.delete(bookLocation);

        return deleteBookLocationResponse;
    }

    @Override
    public List<ListBookLocationResponse> getAll() {
        List<BookLocation> bookLocations=bookLocationRepository.findAll();
        List<ListBookLocationResponse> listBookLocationResponse=BookLocationMapper.INSTANCE.listBookLocationResponse(bookLocations);

        return listBookLocationResponse;
    }

    @Override
    public GetBookLocationResponse getById(int id) {
        BookLocation bookLocation=bookLocationRepository.findById(id).orElseThrow();
        Book book=bookRepository.findById(bookLocation.getBook().getId()).orElseThrow();
        GetBookLocationResponse getBookLocationResponse=BookLocationMapper.INSTANCE.getResponseFromId(bookLocation);

        return getBookLocationResponse;
    }




//    private void bookWithSameNameShouldNotExist(String bookName)
//   {
//        Optional<BookLocation> bookWithSameName = bookLocationRepository
//                .findByNameIgnoreCase(bookName);
//
//        if(bookWithSameName.isPresent())
//            throw new BusinessException("bu kitap zaten ödünç alınmıştır");
//    }

}
