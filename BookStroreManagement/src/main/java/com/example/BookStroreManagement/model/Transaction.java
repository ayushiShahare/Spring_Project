package com.example.BookStroreManagement.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;

    public Transaction(long userId, long amount, Timestamp addedMoneyTime) {
        this.userId=userId;
        this.addedAmount=amount;
        this.addedMoneyTime=addedMoneyTime;
        this.issueTimeStamp=null;
        this.returnTimeStamp=null;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    private long userId;

    private long addedAmount;
    private boolean returnStatus;
    private long bookId;
    private long inventoryId;

    public Transaction(long orderId, long userId, long addedAmount, Date addedMoneyTime) {
        this.orderId = orderId;
        this.userId = userId;
        this.addedAmount = addedAmount;
        this.addedMoneyTime = addedMoneyTime;
    }

    public Transaction() {
    }

//    public Transaction(long orderId, long addedAmount, boolean returnStatus, long bookId, long inventoryId, Date addedMoneyTime, Date returnTimeStamp) {
//        this.orderId = orderId;
//        this.addedAmount = addedAmount;
//        this.returnStatus = returnStatus;
//        this.bookId = bookId;
//        this.inventoryId = inventoryId;
//        this.addedMoneyTime = addedMoneyTime;
//        this.returnTimeStamp = returnTimeStamp;
//    }
//
//    public Transaction(long orderId, long addedAmount, Date addedMoneyTime) {
//        this.orderId = orderId;
//        this.addedAmount = addedAmount;
//        this.addedMoneyTime = addedMoneyTime;
//    }
//
//    public Transaction(long orderId, boolean returnStatus, long bookId, long inventoryId, Date issueTimeStamp) {
//        this.orderId = orderId;
//        this.returnStatus = returnStatus;
//        this.bookId = bookId;
//        this.inventoryId = inventoryId;
//        this.issueTimeStamp = issueTimeStamp;
//    }

    @Column( updatable = false)
    @CreationTimestamp
    private Date addedMoneyTime;
    @Column( updatable = false)
    @CreationTimestamp
    private Date issueTimeStamp;
    @Column( updatable = false)
    @CreationTimestamp
    private Date returnTimeStamp;

    public Transaction(long addedAmount,Date addedMoneyTime) {
        this.addedAmount=addedAmount;
        this.addedMoneyTime=addedMoneyTime;
        this.issueTimeStamp=null;
        this.returnTimeStamp=null;
    }

    public Transaction(long userId, boolean returnStatus, long bookId, long inventoryId) {
        this.userId = userId;
        this.returnStatus = returnStatus;
        this.bookId = bookId;
        this.inventoryId = inventoryId;
    }

    public Transaction(long orderId, long userId, boolean returnStatus, long bookId, long inventoryId, Date issueTimeStamp, Date returnTimeStamp) {
        this.orderId = orderId;
        this.userId = userId;
        this.returnStatus = returnStatus;
        this.bookId = bookId;
        this.inventoryId = inventoryId;
        this.issueTimeStamp = issueTimeStamp;
        this.returnTimeStamp = returnTimeStamp;
    }

    public long getAddedAmount() {
        return addedAmount;
    }

    public void setAddedAmount(long addedAmount) {
        this.addedAmount = addedAmount;
    }

    public boolean isReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(boolean returnStatus) {
        this.returnStatus = returnStatus;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Date getAddedMoneyTime() {
        return addedMoneyTime;
    }

    public void setAddedMoneyTime(Date addedMoneyTime) {
        this.addedMoneyTime = addedMoneyTime;
    }

    public Date getIssueTimeStamp() {
        return issueTimeStamp;
    }

    public void setIssueTimeStamp(Date issueTimeStamp) {
        this.issueTimeStamp = issueTimeStamp;
    }

    public Date getReturnTimeStamp() {
        return returnTimeStamp;
    }

    public void setReturnTimeStamp(Date returnTimeStamp) {
        this.returnTimeStamp = returnTimeStamp;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }



}
