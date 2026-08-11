package com.farhaan.projects.Ace.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    // Exception from all the controllers come here -> don't have to write try-catch block in controller

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequest(BadRequestException ex){
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(apiError.status()).body(apiError);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFound(ResourceNotFoundException ex){
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getResourceName() + " with id : " + ex.getResourceId() + " not found");
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(apiError.status()).body(apiError);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValid(MethodArgumentNotValidException ex){
        List<ApiFieldError> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ApiFieldError(error.getField(), error.getDefaultMessage())).toList();

        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, "Input Validation Failed", errors);
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(apiError.status()).body(apiError);
    }
}
