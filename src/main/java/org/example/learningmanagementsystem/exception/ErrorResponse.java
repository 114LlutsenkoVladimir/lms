package org.example.learningmanagementsystem.exception;


import java.time.Instant;
import java.util.Map;

public record ErrorResponse(
        int status,
        String error,
        String message,
        Instant timestamp,
        Map<String, String> validationErrors
) {
    public ErrorResponse(int status, String error, String message) {
        this(status, error, message, Instant.now(), null);
    }
}
