package com.motus.emotion.controller;

import com.motus.emotion.dto.AuthDto;
import com.motus.emotion.dto.JwtResponse;
import com.motus.emotion.dto.UserDto;
import com.motus.emotion.exception.AlreadyExistException;
import com.motus.emotion.exception.NotFoundException;
import com.motus.emotion.model.User;
import com.motus.emotion.model.api.ApiResponse;
import com.motus.emotion.service.AuthenticationService;
import com.motus.emotion.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/emotion/api/authenticate")
@Validated
@Api("authentication api")
public class HomeRestController {

    private final Logger LOGGER = LoggerFactory.getLogger(HomeRestController.class);

    private AuthenticationService authenticationService;

    @Autowired
    public HomeRestController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(value = "/signin", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    @ApiOperation(value = "generate a token")
    public ApiResponse<JwtResponse> createJwtAuth(@RequestBody @Valid @ApiParam("payload authentication") AuthDto authDto) throws NotFoundException, AlreadyExistException {
        JwtResponse token = new JwtResponse(authenticationService.authenticateJwt(authDto));
        LOGGER.info("Generate token to authenticate");
        return new ApiResponse<>(HttpStatus.OK.value(), "Token generated with success", token);
    }

    @PostMapping("/signup")
    @ApiOperation(value = "register a user")
    public ApiResponse<User> signup(@RequestBody @Valid @ApiParam("full user payload") UserDto userDto) throws AlreadyExistException, NotFoundException {
        LOGGER.info("user registration");
        return new ApiResponse<>(HttpStatus.OK.value(), "User created with success", authenticationService.signUp(userDto));
    }
}
