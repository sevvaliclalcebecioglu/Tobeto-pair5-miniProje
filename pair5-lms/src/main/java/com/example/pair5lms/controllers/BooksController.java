package com.example.pair5lms.controllers;

import com.example.pair5lms.services.abstracts.BookService;
import com.example.pair5lms.services.dtos.requests.book.AddBookRequest;
import com.example.pair5lms.services.dtos.requests.book.UpdateBookRequest;
import com.example.pair5lms.services.dtos.responses.book.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BooksController {
    private BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddBookResponse add(@RequestBody @Valid AddBookRequest request){
        return bookService.add(request);
    }

    @PutMapping
    public UpdateBookResponse update(@RequestBody @Valid UpdateBookRequest request){
        return bookService.update(request);
    }

    @DeleteMapping
    public DeleteBookResponse delete(@RequestParam int id){
        return bookService.delete(id);
    }

    @GetMapping
    public List<ListBookResponse> getAll(){
        return bookService.getAll();
    }

    @GetMapping("/{getById}")
    public GetBookResponse getById(@PathVariable int getById){
        return bookService.getById(getById);
    }
}
