package com.motus.emotion.repository.impl;

import com.motus.emotion.model.User;
import com.motus.emotion.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

abstract class UserRepositoryimpl implements UserRepository {


    private UserRepository userRepository;

    @Override
    public User findByMail(String mail) {
        List<User> userList = new ArrayList();
        userRepository.findAll().forEach((e -> userList.add(e)));
        for(User u : userList) {
            if( u.getMail() == mail ) return u;
        }
        return null;
    }
}