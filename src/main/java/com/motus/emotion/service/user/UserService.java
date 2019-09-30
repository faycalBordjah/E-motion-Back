package com.motus.emotion.service.user;

import com.motus.emotion.model.User;

import java.util.List;

public interface UserService {

    User getById(Long id);

    User getByMail(String mail);

    List<User> getAll();

    User save(User user);

    void delete(Long id);

    void updateUser(User user);

    boolean isUserExist(User user);
}
