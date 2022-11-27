package com.example.BookStroreManagement.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="User")
public class User {
    public User(long userId) {
        this.userId = userId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "userId")
    private long userId;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private String fullName;
    @NotNull
    @Column(unique=true)

    private String username;
    private String address;

    public User() {
    }
    private boolean suspendedStatus;

    public boolean isSuspendedStatus() {
        return suspendedStatus;
    }

    public void setSuspendedStatus(boolean suspendedStatus) {
        this.suspendedStatus = suspendedStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", contactNo=" + contactNo +
                '}';
    }

    public User(long userId, String username, String address, String email, long contactNo) {
        this.userId = userId;
        this.username = username;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
        this.suspendedStatus=false;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }
    @NotNull
    @Column(unique=true)
    private String email;
    @Column(unique=true)
    private long contactNo;

}
