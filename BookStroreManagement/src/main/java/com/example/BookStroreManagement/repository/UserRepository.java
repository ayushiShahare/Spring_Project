package com.example.BookStroreManagement.repository;

import com.example.BookStroreManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
