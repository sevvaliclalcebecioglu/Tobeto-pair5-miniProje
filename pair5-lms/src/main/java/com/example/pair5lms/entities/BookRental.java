package com.example.pair5lms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "book_rentals")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BookRental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_rental_cost")
    private double totalRentalCost;

    @Column(name = "is_all_book_returned")
    private boolean isAllBookReturned;

    @OneToMany(mappedBy = "bookRental")
    List<BookRentalDetail> bookRentalDetails;


}
