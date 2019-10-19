package com.motus.emotion.controller.user;

import com.motus.emotion.model.User;
import com.motus.emotion.model.api.ApiResponse;
import com.motus.emotion.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/emotion/api/user")
public class UserRestController {

    Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ApiResponse<User> getUserById(@PathVariable @Valid final Long userId) {
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
}
