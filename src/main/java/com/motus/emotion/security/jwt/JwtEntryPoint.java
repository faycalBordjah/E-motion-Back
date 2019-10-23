package com.motus.emotion.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Authenticator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {
    private final Logger LOGGER = LoggerFactory.getLogger(JwtEntryPoint.class);

    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {
        LOGGER.warn("Unauthorized  {}", e.getMessage());
        if (e instanceof BadCredentialsException){
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "You have put bad credentials ");
        }else {httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Jwt authentication failed");}
    }
}
