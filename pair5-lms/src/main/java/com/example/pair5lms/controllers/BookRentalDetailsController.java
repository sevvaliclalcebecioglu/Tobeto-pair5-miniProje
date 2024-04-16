package com.example.pair5lms.controllers;

import com.example.pair5lms.services.abstracts.BookRentalDetailService;
import com.example.pair5lms.services.dtos.requests.bookrentaldetail.AddBookRentalDetailRequest;
import com.example.pair5lms.services.dtos.requests.bookrentaldetail.UpdateBookRentalDetailRequest;
import com.example.pair5lms.services.dtos.responses.bookrentaldetail.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book_rental_details")
@AllArgsConstructor
public class BookRentalDetailsController {
    private BookRentalDetailService bookRentalDetailService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddBookRentalDetailResponse add(@RequestBody @Valid AddBookRentalDetailRequest request){
        return bookRentalDetailService.add(request);
    }

    @PutMapping
    public UpdateBookRentalDetailResponse update(@RequestBody @Valid UpdateBookRentalDetailRequest request){
        return bookRentalDetailService.update(request);
    }

    @DeleteMapping
    public DeleteBookRentalDetailResponse delete(@RequestParam int id){
        return bookRentalDetailService.delete(id);
    }

    @GetMapping
    public List<ListBookRentalDetailResponse> getAll(){
        return bookRentalDetailService.getAll();
    }

    @GetMapping("/{getById}")
    public GetBookRentalDetailResponse getById(@PathVariable int getById){
        return bookRentalDetailService.getById(getById);
    }


}

