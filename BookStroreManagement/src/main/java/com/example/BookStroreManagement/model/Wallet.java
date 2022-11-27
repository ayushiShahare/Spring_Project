package com.example.BookStroreManagement.model;

import javax.persistence.*;

@Entity
public class Wallet {
    @Id
    private long id;


    public Wallet() {
    }

//    public Wallet(long id,  long balance, long booksRented) {
//        this.id = id;
//
//        this.balance = balance;
//        this.booksRented = booksRented;
//    }

    public Wallet(long id, long balance, long booksRented) {
        this.id = id;
        this.balance = balance;
        this.booksRented = booksRented;
    }



    private long balance;
    private long booksRented;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getBooksRented() {
        return booksRented;
    }

    public void setBooksRented(long booksRented) {
        this.booksRented = booksRented;
    }
}
