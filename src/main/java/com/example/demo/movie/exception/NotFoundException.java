package com.example.demo.movie.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String movieNotFound) {
        super(movieNotFound);
    }
}
