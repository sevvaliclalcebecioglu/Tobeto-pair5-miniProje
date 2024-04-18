package com.example.pair5lms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "users")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    @Size(min = 2, max = 32)
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 2, max = 32)
    private String lastName;

    @Column(name = "email")
    @Size(max = 100)
    private String email;

    @Column(name = "password")
    @Size(min = 8, max = 32)
    private String password;

    @OneToMany(mappedBy = "user")
    List<BookRental> bookRentals;
}
