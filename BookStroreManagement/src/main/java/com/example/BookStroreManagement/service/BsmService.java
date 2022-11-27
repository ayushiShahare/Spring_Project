package com.example.BookStroreManagement.service;

import com.example.BookStroreManagement.model.Book;
import com.example.BookStroreManagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BsmService {


    Book saveBookEntry(Book book);

    User saveUserEntry(User user);

    User updateUserEntry(User user);

    List<Book> getAllBook();

    void suspendUserByStatus(long userId);

    Book getBookById(long bookId);

    void addMoneyToWallet(long userId, long amount);

    List<Book> getAllAvailableBooks();

    List<Book> sortedBooksByDate();

    List<Book> sortedBooksByLikes();

    void borrowedBook(long userId, long bookId);
}
