package com.example.BookStroreManagement.repository;

import com.example.BookStroreManagement.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepo extends JpaRepository<Wallet,Long> {
}
