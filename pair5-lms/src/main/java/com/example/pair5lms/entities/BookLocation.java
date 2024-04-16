package com.example.pair5lms.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "book_locations")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BookLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "is_available")
    private boolean isAvailable;

    @Column(name = "added_date")
    private LocalDateTime addedDate;

    @OneToMany(mappedBy = "bookLocation")
    List<BookRentalDetail> bookRentalDetails;
}
