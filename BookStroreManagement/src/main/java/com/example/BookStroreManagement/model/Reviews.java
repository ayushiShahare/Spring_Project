package com.example.BookStroreManagement.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.util.Date;

public class Reviews {
    private String review;
    private long bookId;
    private long userId;

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date created_at;
}
