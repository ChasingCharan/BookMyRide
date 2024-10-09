package com.example.BookMyRide.exception;

public class DriversNotFoundException extends RuntimeException {
    public DriversNotFoundException(String message) {
        super(message);
    }
}
