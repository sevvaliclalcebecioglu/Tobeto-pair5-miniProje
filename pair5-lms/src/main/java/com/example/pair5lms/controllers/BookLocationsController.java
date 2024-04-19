package com.example.pair5lms.controllers;

import com.example.pair5lms.services.abstracts.BookLocationService;
import com.example.pair5lms.services.dtos.requests.booklocation.*;
import com.example.pair5lms.services.dtos.responses.booklocation.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booklocations")
@AllArgsConstructor
public class BookLocationsController {
    private BookLocationService bookLocationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddBookLocationResponse add(@RequestBody @Valid AddBookLocationRequest request) {
        return bookLocationService.add(request);
    }

    @PutMapping
    public UpdateBookLocationResponse update(@RequestBody @Valid UpdateBookLocationRequest request) {
        return bookLocationService.update(request);
    }

    @DeleteMapping
    public DeleteBookLocationResponse delete(@RequestParam int id) {
        return bookLocationService.delete(id);
    }

    @GetMapping
    public List<ListBookLocationResponse> getAll() {
        return bookLocationService.getAll();
    }

    @GetMapping("/{getById}")
    public GetBookLocationResponse getById(@PathVariable int getById) {
        return bookLocationService.getById(getById);
    }


}
