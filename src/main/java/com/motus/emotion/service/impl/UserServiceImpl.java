package com.motus.emotion.service.impl;

import com.motus.emotion.exception.NotFoundException;
import com.motus.emotion.model.User;
import com.motus.emotion.repository.UserRepository;
import com.motus.emotion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getByMail(String mail) {
        return userRepository.findByMail(mail);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User save(User user) {
        user.setCreationDate(new Date());
        user.setModificationDate(new Date());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, User current) throws NotFoundException {
        /**
         * We need to insert a business code here
         */
        if (getById(current.getId()) == null){
            throw new NotFoundException("user not found");
        }
        user.setAddress(current.getAddress());
        user.setFirstName(current.getFirstName());
        user.setLastName(current.getLastName());
        user.setBirthDay(current.getBirthDay());
        user.setCreationDate(current.getCreationDate());
        user.setModificationDate(new Date());
        user.setPermitNum(current.getPermitNum());
        return userRepository.save(user);
    }

    @Override
    public boolean isUserExist(User user) {
        return getByMail(user.getMail()) != null;
    }
}

