package com.example.pair5lms.services.mappers;

import com.example.pair5lms.entities.BookRental;
import com.example.pair5lms.entities.User;
import com.example.pair5lms.services.dtos.requests.bookrental.AddBookRentalRequest;
import com.example.pair5lms.services.dtos.requests.bookrental.UpdateBookRentalRequest;
import com.example.pair5lms.services.dtos.responses.book.ListBookResponse;
import com.example.pair5lms.services.dtos.responses.bookrental.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface BookRentalMapper {
    BookRentalMapper INSTANCE = Mappers.getMapper(BookRentalMapper.class);

    @Mapping(target = "user.id", source = "userId")
    BookRental bookRentalFromAddRequest(AddBookRentalRequest request);

    @Mapping(target = "userName", expression = "java(user.getFirstName() + \" \" + user.getLastName())")
    @Mapping(target = "id", source = "bookRental.id")
    AddBookRentalResponse addResponseFromBookRental(BookRental bookRental, User user);

    @Mapping(target = "user.id", source = "userId")
    BookRental bookRentalFromUpdateRequest(UpdateBookRentalRequest request);

    @Mapping(target = "userName", expression = "java(user.getFirstName() + \" \" + user.getLastName())")
    @Mapping(target = "id", source = "bookRental.id")
    UpdateBookRentalResponse updateResponseFromBookRental(BookRental bookRental, User user);

    @Mapping(target = "userName", expression = "java(user.getFirstName() + \" \" + user.getLastName())")
    @Mapping(target = "id", source = "bookRental.id")
    DeleteBookRentalResponse deleteResponseFromId(BookRental bookRental, User user);

    @Mapping(target = "userName", expression = "java(bookRental.getUser().getFirstName() + \" \" + bookRental.getUser().getLastName())")
    ListBookRentalResponse listBookRentalResponseMap(BookRental bookRental);

    List<ListBookRentalResponse> listBookRentalResponse(List<BookRental> bookRentals);

    @Mapping(target = "userName", expression = "java(bookRental.getUser().getFirstName() + \" \" + bookRental.getUser().getLastName())")
    GetBookRentalResponse getResponseFromId(BookRental bookRental);
}
