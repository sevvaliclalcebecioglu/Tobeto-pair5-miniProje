package com.example.pair5lms.services.dtos.responses.book;

import lombok.Data;

@Data
public class GetBookResponse {
    private int id;

    private int isbn;

    private String name;

    private String author;

    private int page;

    private double price;
}
