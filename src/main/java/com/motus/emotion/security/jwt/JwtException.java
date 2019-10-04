package com.motus.emotion.security.jwt;

import org.springframework.security.core.AuthenticationException;

public class JwtException extends AuthenticationException {

    public JwtException(String msg) {
        super(msg);
    }
}
