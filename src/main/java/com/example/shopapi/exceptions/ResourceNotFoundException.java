package com.example.shopapi.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("No resource found with provided search criteria!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
