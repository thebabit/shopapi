package com.example.shopapi.exceptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException() {
        super("An invalid request was made!");
    }

    public BadRequestException(String message) {
        super(message);
    }

}
