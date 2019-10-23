package com.motus.emotion.controller.admin;

import com.motus.emotion.exception.NotFoundException;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/emotion/api/admin")
@Validated
@Api("Api for user rest service")
public class UsersRestController {

    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UsersRestController.class);

    @Autowired
    public UsersRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "get all available users")
    @ResponseBody
    public ApiResponse<List<User>> getAllUsers() {
        logger.info("Fetching all Users");
        List<User> users;
        if (userService.getAll().isEmpty()) {
            logger.warn("Unable to fetch an empty list");
            return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Unable to fetch an empty list.", null);
        };
        users = userService.getAll().stream().filter(user -> !Objects.deepEquals(user,userService.getById(1L))).collect(Collectors.toList());
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.", users);
    }

    @GetMapping(value = "/users/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @ApiOperation(value = "get a user by his id")
    public ApiResponse<User> getUser(@PathVariable @ApiParam final Long userId) {
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
    @ApiOperation(value = "update user information")
    public ApiResponse<User> updateUser(@PathVariable @ApiParam final Long userId, @RequestBody @Valid User user) throws NotFoundException {
        logger.info("Updating Client with id {}", userId);
        User currentUser = userService.getById(userId);
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.", userService.updateUser(currentUser, user));
    }

    @DeleteMapping(value = "/users/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @ApiOperation(value = "delete a user")
    public ApiResponse<User> delete(@PathVariable @ApiParam final Long userId) {
        logger.info("Fetching & Deleting User with id {}", userId);
        User user = userService.getById(userId);
        if (user == null) {
            logger.error("Unable to delete. User with id {} not found.", userId);
            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Unable to delete. User with id " + userId + " not found.", userService.getById(userId));
        }
        if (userService.isAdmin(userId,user.getMail())) {
            return new ApiResponse<>(HttpStatus.FORBIDDEN.value(), "You can not delete the admin", userService.getById(userId));
        }
        userService.delete(userId);
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", userService.getById(userId));

    }

}
