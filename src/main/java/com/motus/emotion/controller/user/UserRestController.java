package com.motus.emotion.controller.user;

import com.motus.emotion.dto.UserDto;
import com.motus.emotion.exception.ForbiddenExceptionEmo;
import com.motus.emotion.model.User;
import com.motus.emotion.model.api.ApiResponse;
import com.motus.emotion.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/emotion/api/user")
@Api("Api responsible of users")
public class UserRestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @ApiOperation(value = "find a user by his id")
    public ApiResponse<User> getProfile(@PathVariable @ApiParam final Long userId) {
        LOGGER.info("Fetching User with id {}", userId);
        User user = userService.getById(userId);
        if (user == null) {
            LOGGER.error("User with id {} is not found.", userId);
            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "User with id " + userId
                    + " not found.", userService.getById(userId));
        }
        return new ApiResponse<>(HttpStatus.OK.value(), "User with id " + userId
                + "fetched successfully.", userService.getById(userId));
    }

    @PutMapping(value = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @ApiOperation(value = "update  a user information (profil) by his id")
    public ApiResponse<User> updateProfile(@PathVariable @ApiParam("user id") Long userId,@Valid @RequestBody @ApiParam(value = "User dto that contains info to update in the profile ") UserDto userDto) {
        LOGGER.info("Fetching User with id for Update his profile {}", userId);
        LOGGER.info("Fetching User with id for Update his profile {}", userDto.getMail());
        if (userService.isAdmin(userId,userDto.getMail())) {
            return new ApiResponse<>(HttpStatus.FORBIDDEN.value(), "You can not delete the admin", userService.getById(userId));
        }
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated with success", userService.updateProfile(userId, userDto));
    }
}
