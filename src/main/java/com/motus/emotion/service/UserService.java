package com.motus.emotion.service;

import com.motus.emotion.exception.NotFoundException;
import com.motus.emotion.model.User;
import com.motus.emotion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(Long id) throws NotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }

    public User addUser(User user){
        return userRepository.save(user);
    }
}
