package com.motus.emotion.controller;

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
@RequestMapping(value = "/emotion/api/users")
@CrossOrigin(origins = "*")
@Validated
public class UserController {

    private UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
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

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ApiResponse<User> getUserById(@PathVariable @Valid final Long id) {
        logger.info("Fetching User with id {}", id);
        User user = userService.getById(id);
        if (user == null) {
            logger.error("User with id {} is not found.", id);
            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "User with id " + id
                    + " not found.", userService.getById(id));

        }
        return new ApiResponse<>(HttpStatus.OK.value(), "User with id " + id
                + "fetched successfully.", userService.getById(id));

    }

    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ApiResponse<User> updateUser(@PathVariable @Valid final Long id, @RequestBody @Valid User user) throws NotFoundException {
        logger.info("Updating Client with id {}", id);
        User currentUser = userService.getById(id);
        if (currentUser == null) {
            logger.error("Unable to update. User with id {}  is not found", id);
            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Unable to update. User with id " + id + " not found.", userService.getById(id));
        }
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.", userService.updateUser(currentUser, user));
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ApiResponse<User> delete(@PathVariable final Long id) {
        logger.info("Fetching & Deleting User with id {}", id);
        User user = userService.getById(id);

        if (user == null) {
            logger.error("Unable to delete. User with id {} not found.", id);
            return new ApiResponse<User>(HttpStatus.NOT_FOUND.value(), "Unable to delete. User with id " + id + " not found.", userService.getById(id));
        }
        userService.delete(id);
        return new ApiResponse<User>(HttpStatus.NO_CONTENT.value(), "User delated successfully.", userService.getById(id));

    }

}
