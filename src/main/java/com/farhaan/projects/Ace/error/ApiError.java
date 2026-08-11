package com.farhaan.projects.Ace.error;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public record ApiError (
        HttpStatus status,
        String message,
        Instant timestamp
) {
    public ApiError(HttpStatus status, String message) {
        this(status, message, Instant.now()); //we created a second constructor which calls the main constructor automatically created by record class
    }
}
