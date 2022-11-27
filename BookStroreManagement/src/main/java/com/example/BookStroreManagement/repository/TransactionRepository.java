package com.example.BookStroreManagement.repository;

import com.example.BookStroreManagement.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
