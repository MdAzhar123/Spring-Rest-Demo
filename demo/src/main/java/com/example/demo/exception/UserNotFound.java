package com.example.demo.exception;

// Instead of showing internal server error in postman we want to show not found response

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFound extends RuntimeException {
    public UserNotFound(String message) {
        super(message);
    }

}
