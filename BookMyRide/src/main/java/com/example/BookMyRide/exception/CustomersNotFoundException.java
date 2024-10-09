package com.example.BookMyRide.exception;

public class CustomersNotFoundException extends RuntimeException {
    public CustomersNotFoundException(String message) {
        super(message);
    }
}
