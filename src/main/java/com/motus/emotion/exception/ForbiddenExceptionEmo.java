package com.motus.emotion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenExceptionEmo extends RuntimeException {
    private String msg;

    public ForbiddenExceptionEmo(String msg) {
        super(String.format("The user %s has not required rights ",msg));
    }
}
