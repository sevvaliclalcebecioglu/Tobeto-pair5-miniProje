package com.example.pair5lms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "books")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "isbn" , unique = true)
    private int isbn;

    @Column(name = "author")
    @Size(min = 2, max = 32)
    private String author;

    @Column(name = "price")
    private double price;

    @Column(name = "name")
    @Size(min = 2, max = 255)
    private String name;

    @Column(name = "page")
    private int page;

    @OneToMany(mappedBy = "book")
    List<BookLocation> bookLocations;

}
