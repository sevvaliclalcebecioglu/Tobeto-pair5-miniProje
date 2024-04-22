package com.example.pair5lms.controllers;

import com.example.pair5lms.services.abstracts.BookRentalService;
import com.example.pair5lms.services.dtos.requests.bookrental.*;
import com.example.pair5lms.services.dtos.responses.bookrental.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookrentals")
@AllArgsConstructor
public class BookRentalsController {
    private BookRentalService bookRentalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddBookRentalResponse add(@RequestBody @Valid AddBookRentalRequest request) {
        return bookRentalService.add(request);
    }

    @PutMapping
    public UpdateBookRentalResponse update(@RequestBody @Valid UpdateBookRentalRequest request) {
        return bookRentalService.update(request);
    }

    @DeleteMapping
    public DeleteBookRentalResponse delete(@RequestParam int id) {
        return bookRentalService.delete(id);
    }

    @GetMapping
    public List<ListBookRentalResponse> getAll() {
        return bookRentalService.getAll();
    }

    @GetMapping("/{getById}")
    public GetBookRentalResponse getById(@PathVariable int getById) {
        return bookRentalService.getById(getById);
    }
}
