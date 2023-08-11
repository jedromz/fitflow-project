package com.fitflow.config;

import com.fitflow.model.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleNoSuchElementException(EntityNotFoundException ex) {
        // Wrap your existing error payload into a new one, or create your own.
        ApiError apiError = new ApiError(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                ex.getEntityName(),
                ex.getKey(),
                ex.getValue(),
                ex.getMessage()
        );
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    public static class ApiError {
        private Instant timestamp;
        private int status;
        private String entity;
        private String key;
        private String value;
        private String trace;
    }
}
