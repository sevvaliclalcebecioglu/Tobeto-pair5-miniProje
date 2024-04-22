package com.example.pair5lms.repositories;

import com.example.pair5lms.entities.BookLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookLocationRepository extends JpaRepository<BookLocation, Integer> {
    List<BookLocation> findByBookId(int id);
}
