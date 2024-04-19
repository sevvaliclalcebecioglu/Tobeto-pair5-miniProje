package com.example.pair5lms.repositories;

import com.example.pair5lms.entities.BookRental;
import com.example.pair5lms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>  {
}
