package com.example.pair5lms.repositories;

import com.example.pair5lms.entities.Book;
import com.example.pair5lms.services.dtos.responses.book.ListBookResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {


//    @Query(value = "select new com.example.pair5lms.services.dtos.responses.book.ListBookResponse(b.id,b.author,b.name,b.page) from" +
//            " Book b inner join BookLocation bl on b.id=bl.book.id " +
//            " where bl.isAvailable=true and  LOWER (b.name) LIKE CONCAT('%', LOWER(:name),'%')",nativeQuery = false)
//    List<ListBookResponse> searchByBookName(String name);

    @Query(value = "SELECT b.price FROM Book AS b WHERE b.id = :id")
    double getPriceFromId(int id);

}
