package com.motus.emotion.service;

import com.motus.emotion.exception.NotFoundException;
import com.motus.emotion.model.User;
import com.motus.emotion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional <User> getUser(Long id) throws NotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new NotFoundException("dddd");
        }
        return userRepository.findById(id);
    }

    public User addUser(User user){
        return userRepository.save(user);
    }
}
