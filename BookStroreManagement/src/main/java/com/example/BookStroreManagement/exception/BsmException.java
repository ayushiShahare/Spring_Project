package com.example.BookStroreManagement.exception;

public class BsmException extends RuntimeException{
    private static final long serviceVersionUID = 1L;

    public BsmException(String message){
        super(message);
    }

    public BsmException(String message, Throwable throwable) {
        super(message, throwable);
    }
}