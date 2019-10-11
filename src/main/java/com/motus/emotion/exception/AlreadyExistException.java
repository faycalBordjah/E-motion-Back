package com.motus.emotion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AlreadyExistException extends RuntimeException {

    private String resourceName;

    public AlreadyExistException(String resourceName) {
        super(String.format("The %s already exits ", resourceName));
    }
}
