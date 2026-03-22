package com.example.springbootLab.exception;
import java.rmi.ServerError;
import java.util.*;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> notFound(Exception ex) {
    return Map.of("error", ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> serverErr(Exception ex) {
        return Map.of("server error", ex.getMessage());
    }
}
