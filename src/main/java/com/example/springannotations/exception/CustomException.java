package com.example.springannotations.exception;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}