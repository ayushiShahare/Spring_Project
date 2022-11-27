package com.example.BookStroreManagement.repository;

import com.example.BookStroreManagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
