package com.example.pair5lms.services.mappers;

import com.example.pair5lms.entities.Book;
import com.example.pair5lms.entities.BookLocation;
import com.example.pair5lms.services.dtos.requests.booklocation.AddBookLocationRequest;
import com.example.pair5lms.services.dtos.requests.booklocation.UpdateBookLocationRequest;
import com.example.pair5lms.services.dtos.responses.booklocation.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring", uses = {UserMapper.class})

public interface BookLocationMapper {
    BookLocationMapper INSTANCE = Mappers.getMapper(BookLocationMapper.class);
    @Mapping(target = "book.id" ,source = "bookId")
    BookLocation bookLocationFromAddRequest(AddBookLocationRequest request);
    @Mapping(target = "bookName",expression = "java(book.getName())")
    @Mapping(target = "id" ,source = "bookLocation.id")
    AddBookLocationResponse addResponseFromBookLocation(BookLocation bookLocation, Book book);

    @Mapping(target = "book.id" ,source = "bookId")
    BookLocation bookLocationFromUpdateRequest(UpdateBookLocationRequest request);
    @Mapping(target = "bookName",expression = "java(book.getName())")
    @Mapping(target = "id" ,source = "bookLocation.id")
    UpdateBookLocationResponse updateResponseFromBookLocation(BookLocation bookLocation, Book book);

    DeleteBookLocationResponse deleteResponseFromId(BookLocation bookLocation);
    @Mapping(target = "bookName",expression = "java(bookLocation.getBook().getName())")
    ListBookLocationResponse listBookLocationResponseMap(BookLocation bookLocation);
    List<ListBookLocationResponse> listBookLocationResponse(List<BookLocation> bookLocations);

    @Mapping(target = "bookName",expression = "java(bookLocation.getBook().getName())")
    @Mapping(target = "id" ,source = "bookLocation.id")
    GetBookLocationResponse getResponseFromId(BookLocation bookLocation);
}
