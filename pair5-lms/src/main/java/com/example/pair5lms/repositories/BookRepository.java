package com.example.pair5lms.repositories;

import com.example.pair5lms.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book , Integer > {
}
