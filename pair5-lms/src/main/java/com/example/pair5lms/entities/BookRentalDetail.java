package com.example.pair5lms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "book_rental_details")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BookRentalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_location_id")
    private BookLocation bookLocation;

    @ManyToOne
    @JoinColumn(name = "book_rental_id")
    private BookRental bookRental;

    @Column(name = "rental_start_date")
    private LocalDateTime rentalStartDate;

    @Column(name = "rental_end_date")
    private LocalDateTime rentalEndDate;

    @Column(name = "rental_return_date")
    private LocalDateTime rentalReturnDate;

    @Column(name = "is_returned")
    private boolean isReturned;
}
