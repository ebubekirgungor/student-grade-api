package com.ebubekirgungor.student_grade_api.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ StudentAlreadyExistsException.class })
    public ResponseEntity<Map<String, String>> handleStudentAlreadyExistsException(
            StudentAlreadyExistsException exception) {
        Map<String, String> body = new HashMap<>();
        body.put("error", exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(body);
    }

    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException exception) {
        Map<String, String> body = new HashMap<>();
        body.put("error", exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(body);
    }
}