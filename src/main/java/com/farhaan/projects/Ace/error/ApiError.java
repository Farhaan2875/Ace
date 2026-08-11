package com.farhaan.projects.Ace.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

public record ApiError (
        HttpStatus status,
        String message,
        Instant timestamp,
        @JsonInclude(JsonInclude.Include.NON_NULL) List<ApiFieldError> errors // only include this field in JSON response if it is not null
) {
    public ApiError(HttpStatus status, String message) {
        this(status, message, Instant.now(), null); //we created a second constructor which calls the main constructor automatically created by record class
    }

    public ApiError(HttpStatus status, String message, List<ApiFieldError> errors) {
        this(status, message, Instant.now(), errors); //we created a second constructor which calls the main constructor automatically created by record class
    }


}

record ApiFieldError(String field, String message){}
