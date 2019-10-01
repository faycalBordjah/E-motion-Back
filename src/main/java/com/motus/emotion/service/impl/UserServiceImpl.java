package com.motus.emotion.service.impl;

import com.motus.emotion.model.User;
import com.motus.emotion.repository.UserRepository;
import com.motus.emotion.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value="userService")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) { this.userRepository = userRepository; }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(userList::add);
        return userList;
    }

    @Override
    public User getByMail(String mail) {
        return userRepository.findByMail(mail);
    }

    @Override
    public User getById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User save(User user){
        return userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        Optional<User> userUpdated = userRepository.findById(user.getId());
        if(userUpdated.isPresent()) {
            BeanUtils.copyProperties(user, userUpdated, "password");
        }
        userRepository.save(user);
    }

    @Override
    public boolean isUserExist(User user) { return getByMail(user.getMail()) != null; }
}

