package com.mongo.demo.adapters.in.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class ValidationExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> ValidationException(MethodArgumentNotValidException ex) {

        Map<String, Object> response = new HashMap<>();

        response.put("status", HttpStatus.BAD_REQUEST);
        response.put("message", Objects.requireNonNull(ex.getMessage()));

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }






}
