package com.example.BookStroreManagement.model;

import javax.persistence.*;

@Entity
public class BookInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long inventoryId;

    private boolean status=true;

    public BookInventory() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private long bookId;

    public Long getInventoryId() {
        return inventoryId;
    }

    public BookInventory(Long inventoryId, long bookId, String bookName) {
        this.inventoryId = inventoryId;
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public BookInventory(long bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    private String bookName;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }



}
