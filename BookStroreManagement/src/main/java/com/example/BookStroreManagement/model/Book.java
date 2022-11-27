package com.example.BookStroreManagement.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

import javax.persistence.*;
//import java.sql.Date;
import java.util.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotNull
    private String bookName;
    @NotNull
    private String bookAuthor;
    private String bookCategory;
    @NotNull

    private long bookId;
    @NotNull
    private long bookPrice;

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookCategory='" + bookCategory + '\'' +
                ", bookId=" + bookId +
                ", bookPrice=" + bookPrice +
                ", bookQuantity=" + bookQuantity +
                ", bookLikes=" + bookLikes +
                ", created_at=" + created_at +
                '}';
    }

    public Book(String bookName, String bookAuthor, String bookCategory, long bookId, long bookPrice, long bookQuantity, long bookLikes, Date created_at) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookCategory = bookCategory;
        this.bookId = this.id;
        this.bookPrice = bookPrice;
        this.bookQuantity = bookQuantity;
        this.bookLikes = bookLikes;
        this.created_at = created_at;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(long bookPrice) {
        this.bookPrice = bookPrice;
    }

    public long getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(long bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public long getBookLikes() {
        return bookLikes;
    }

    public void setBookLikes(long bookLikes) {
        this.bookLikes = bookLikes;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    private long bookQuantity;
    private long bookLikes;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date created_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}

