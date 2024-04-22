package com.example.pair5lms.services.mappers;

import com.example.pair5lms.entities.Book;
import com.example.pair5lms.entities.User;
import com.example.pair5lms.services.dtos.requests.book.AddBookRequest;
import com.example.pair5lms.services.dtos.requests.book.UpdateBookRequest;
import com.example.pair5lms.services.dtos.requests.user.UpdateUserRequest;
import com.example.pair5lms.services.dtos.responses.book.*;
import com.example.pair5lms.services.dtos.responses.user.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book bookFromAddRequest(AddBookRequest request);

    AddBookResponse addResponseFromBook(Book book);

    Book bookFromUpdateRequest(UpdateBookRequest request);

    UpdateBookResponse updateResponseFromBook(Book book);

    DeleteBookResponse deleteResponseFromId(Book book);

    ListBookResponse listBookResponseMap(Book book);

    List<ListBookResponse> listBookResponse(List<Book> books);

    GetBookResponse getResponseFromId(Book book);

    Book bookFromGetResponse(GetBookResponse getBookResponse);
}
