package com.example.pair5lms.services.dtos.responses.book;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookResponse {
    private int id;

    private int isbn;

    private String name;

    private String author;

    private int page;

    private double price;
}
