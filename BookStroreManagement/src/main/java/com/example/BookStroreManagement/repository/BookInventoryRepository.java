package com.example.BookStroreManagement.repository;

import com.example.BookStroreManagement.model.BookInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookInventoryRepository extends JpaRepository<BookInventory,Long> {
}
