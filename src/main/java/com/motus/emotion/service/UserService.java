package com.motus.emotion.service;

import com.motus.emotion.exception.NotFoundException;
import com.motus.emotion.model.User;

import java.util.List;

public interface UserService {

    User getById(Long id);

    User getByMail(String mail);

    List<User> getAll();

    User save(User user);

    void delete(Long id);

    User updateUser(User user, User current) throws NotFoundException;

    boolean isUserExist(User user);
}
