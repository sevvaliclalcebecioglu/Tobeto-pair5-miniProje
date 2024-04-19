package com.example.pair5lms.repositories;

import com.example.pair5lms.entities.BookRental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRentalRepository extends JpaRepository<BookRental, Integer> {

}
