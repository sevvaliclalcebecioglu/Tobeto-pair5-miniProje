package com.example.pair5lms.services.mappers;

import com.example.pair5lms.entities.BookRentalDetail;
import com.example.pair5lms.services.dtos.requests.bookrentaldetail.AddBookRentalDetailRequest;
import com.example.pair5lms.services.dtos.requests.bookrentaldetail.UpdateBookRentalDetailRequest;
import com.example.pair5lms.services.dtos.responses.bookrentaldetail.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookRentalDetailMapper {
    BookRentalDetailMapper INSTANCE = Mappers.getMapper(BookRentalDetailMapper.class);

    @Mapping(target = "bookLocation.id", source = "bookLocationId")
    @Mapping(target = "bookRental.id", source = "bookRentalId")
    BookRentalDetail bookRentalDetailFromAddRequest(AddBookRentalDetailRequest request);

    @Mapping(target = "bookLocationId", source = "bookLocation.id")
    @Mapping(target = "bookRentalId", source = "bookRental.id")
    AddBookRentalDetailResponse addResponseFromBookRentalDetail(BookRentalDetail bookRentalDetail);

    @Mapping(target = "bookLocation.id", source = "bookLocationId")
    @Mapping(target = "bookRental.id", source = "bookRentalId")
    BookRentalDetail bookRentalDetailFromUpdateRequest(UpdateBookRentalDetailRequest request);

    @Mapping(target = "bookLocationId", source = "bookLocation.id")
    @Mapping(target = "bookRentalId", source = "bookRental.id")
    UpdateBookRentalDetailResponse updateResponseFromBookRentalDetail(BookRentalDetail bookRentalDetail);

    DeleteBookRentalDetailResponse deleteResponseFromId(BookRentalDetail bookRentalDetail);

    @Mapping(target = "bookLocationId", source = "bookLocation.id")
    @Mapping(target = "bookRentalId", source = "bookRental.id")
    ListBookRentalDetailResponse listResponseFromBookRentalDetailMap(BookRentalDetail bookRentalDetail);

    List<ListBookRentalDetailResponse> listResponseFromBookRentalDetails(List<BookRentalDetail> bookRentalDetails);

    @Mapping(target = "bookLocationId", source = "bookLocation.id")
    @Mapping(target = "bookRentalId", source = "bookRental.id")
    GetBookRentalDetailResponse getBookRentalDetailResponseFromBookRentalDetail(BookRentalDetail bookRentalDetail);
}
