package com.example.pair5lms.services.dtos.responses.book;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListBookResponse {

    public ListBookResponse(int id, String name, String author, int page) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.page = page;
    }

    private int id;

    private int isbn;

    private String name;

    private String author;

    private int page;

    private double price;
}
