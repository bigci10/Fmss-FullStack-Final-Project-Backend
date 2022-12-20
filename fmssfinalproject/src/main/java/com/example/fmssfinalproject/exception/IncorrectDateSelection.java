package com.example.fmssfinalproject.exception;

import org.springframework.http.HttpStatus;

public class IncorrectDateSelection extends RuntimeException {
    public IncorrectDateSelection(String message) {
        super(message);
    }
}
