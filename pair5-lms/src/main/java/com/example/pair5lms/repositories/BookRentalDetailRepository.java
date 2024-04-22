package com.example.pair5lms.repositories;

import com.example.pair5lms.entities.BookRental;
import com.example.pair5lms.entities.BookRentalDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRentalDetailRepository extends JpaRepository<BookRentalDetail, Integer> {
    List<BookRentalDetail> findAllByBookRentalId(int id);
    BookRentalDetail findByBookRentalIdAndBookLocationId(int bookRentalId, int booklocationId);
}
