package com.motus.emotion.controller;

import com.motus.emotion.dto.AuthDto;
import com.motus.emotion.dto.JwtResponse;
import com.motus.emotion.model.User;
import com.motus.emotion.model.api.ApiResponse;
import com.motus.emotion.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@RequestMapping(value = "/emotion/api/authenticate")
@Validated
public class HomeRestController {
    @Autowired
    private AuthenticationManager authenticationManager;

    private JwtProvider jwtProvider;

    @PostMapping("")
    @ResponseBody
    public ApiResponse<JwtResponse> createJwtAuth(@RequestBody @Valid AuthDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.createToken()
        return null;
    }


    public User singUp(AuthDto loginDto) {
        return null;
    }

}
