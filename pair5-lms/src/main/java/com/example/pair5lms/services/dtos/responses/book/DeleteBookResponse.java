package com.example.pair5lms.services.dtos.responses.book;

import lombok.Data;

@Data
public class DeleteBookResponse {
    private int id;

    private int isbn;

    private String name;

    private int page;
}
