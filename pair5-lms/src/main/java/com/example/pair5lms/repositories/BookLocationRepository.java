package com.example.pair5lms.repositories;

import com.example.pair5lms.entities.BookLocation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookLocationRepository extends JpaRepository<BookLocation, Integer> {
    // Optional<BookLocation> findByNameIgnoreCase(String bookName);

}
