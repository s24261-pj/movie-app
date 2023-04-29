package com.example.demo.movie.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String badRequest) {
        super(badRequest);
    }
}
