package com.motus.emotion.controller;

import com.motus.emotion.exception.NotFoundException;
import com.motus.emotion.model.User;
import com.motus.emotion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/emotion/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable(value = "id")Long id) throws NotFoundException {
        return userService.getUser(id);
    }

    @PostMapping
    public User addUser(@Valid @RequestBody User user){
        return userService.addUser(user);
    }
}
