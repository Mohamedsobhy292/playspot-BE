package com.mohamedsobhy292.playspot;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mohamedsobhy292.playspot.exceptions.BadRequestException;
import com.mohamedsobhy292.playspot.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<HashMap<String, String>> handleBadRequestException(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<String, String>() {
            {
                put("error_message", ex.getMessage());
            }
        });
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<HashMap<String, String>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<String, String>() {
            {
                put("error_message", ex.getMessage());
            }
        });
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HashMap<String, String>> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new HashMap<>() {
            {
                put("error_message", ex.getMessage());
            }
        });
    }
}
