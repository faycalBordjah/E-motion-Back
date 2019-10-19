package com.motus.emotion.controller.admin;

import com.motus.emotion.exception.NotFoundException;
import com.motus.emotion.model.User;
import com.motus.emotion.model.api.ApiResponse;
import com.motus.emotion.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/emotion/api/admin")
@Validated
public class UsersRestController {

    private UserService userService;

    Logger logger = LoggerFactory.getLogger(UsersRestController.class);

    @Autowired
    public UsersRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ApiResponse<List<User>> getAllUsers() {
        logger.info("Fetching all Users");
        List<User> userList = userService.getAll();
        if (userList.isEmpty()) {
            logger.warn("Unable to fetch an empty list");
            return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Unable to fetch an empty list.", userService.getAll());
        }
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.", userService.getAll());
    }

    @GetMapping(value = "/users/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ApiResponse<User> getUserById(@PathVariable @Valid final Long userId) {
        logger.info("Fetching User with id {}", userId);
        User user = userService.getById(userId);
        if (user == null) {
            logger.error("User with id {} is not found.", userId);
            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "User with id " + userId
                    + " not found.", userService.getById(userId));

        }
        return new ApiResponse<>(HttpStatus.OK.value(), "User with id " + userId
                + "fetched successfully.", userService.getById(userId));

    }

    @PutMapping(value = "/users/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ApiResponse<User> updateUser(@PathVariable @Valid final Long userId, @RequestBody @Valid User user) throws NotFoundException {
        logger.info("Updating Client with id {}", userId);
        User currentUser = userService.getById(userId);
        if (currentUser == null) {
            logger.error("Unable to update. User with id {}  is not found", userId);
            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Unable to update. User with id " + userId + " not found.", userService.getById(userId));
        }
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.", userService.updateUser(currentUser, user));
    }

    @DeleteMapping(value = "/users/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ApiResponse<User> delete(@PathVariable final Long userId) {
        logger.info("Fetching & Deleting User with id {}", userId);
        User user = userService.getById(userId);

        if (user == null) {
            logger.error("Unable to delete. User with id {} not found.", userId);
            return new ApiResponse<User>(HttpStatus.NOT_FOUND.value(), "Unable to delete. User with id " + userId + " not found.", userService.getById(userId));
        }
        if (userId == 1) {
            return new ApiResponse<>(HttpStatus.FORBIDDEN.value(), "You can not delete the admin", userService.getById(userId));
        }
        userService.delete(userId);
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", userService.getById(userId));

    }

}
