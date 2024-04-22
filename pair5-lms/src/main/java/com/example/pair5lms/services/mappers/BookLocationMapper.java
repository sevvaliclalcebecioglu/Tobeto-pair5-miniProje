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

@Mapper(componentModel = "spring")
public interface BookLocationMapper {
    BookLocationMapper INSTANCE = Mappers.getMapper(BookLocationMapper.class);

    @Mapping(target = "book.id", source = "bookId")
    BookLocation bookLocationFromAddRequest(AddBookLocationRequest request);

    @Mapping(target = "id", source = "bookLocation.id")
    @Mapping(target = "bookName", source = "bookLocation.book.name")
    AddBookLocationResponse addResponseFromBookLocation(BookLocation bookLocation);

    @Mapping(target = "book.id", source = "bookId")
    BookLocation bookLocationFromUpdateRequest(UpdateBookLocationRequest request);

    @Mapping(target = "id", source = "bookLocation.id")
    @Mapping(target = "bookName", source = "bookLocation.book.name")
    UpdateBookLocationResponse updateResponseFromBookLocation(BookLocation bookLocation);

    @Mapping(target = "bookName", source = "book.name")
    @Mapping(target = "id", source = "bookLocation.id")
    DeleteBookLocationResponse deleteResponseFromId(BookLocation bookLocation, Book book);

    @Mapping(target = "bookName", source = "book.name")
    ListBookLocationResponse listBookLocationResponseMap(BookLocation bookLocation);

    List<ListBookLocationResponse> listBookLocationResponse(List<BookLocation> bookLocations);

    @Mapping(target = "bookName", source = "book.name")
    @Mapping(target = "id", source = "bookLocation.id")
    GetBookLocationResponse getResponseFromId(BookLocation bookLocation);

    @Mapping(target = "bookId", source = "bookLocation.book.id")
    UpdateBookLocationRequest updateRequestFromBookLocation(BookLocation bookLocation);

    BookLocation bookLocationFromGetResponse(GetBookLocationResponse getBookLocationResponse);
}
