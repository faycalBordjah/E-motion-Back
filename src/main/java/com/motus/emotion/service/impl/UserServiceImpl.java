package com.motus.emotion.service.impl;

import com.motus.emotion.dto.UserDto;
import com.motus.emotion.exception.NotFoundException;
import com.motus.emotion.model.RoleName;
import com.motus.emotion.model.User;
import com.motus.emotion.repository.UserRepository;
import com.motus.emotion.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

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
    public User getByMail(String mail) throws NotFoundException {
        if (userRepository.findByMail(mail).isEmpty()){
            throw new NotFoundException("user not found");
        }
        return userRepository.findByMail(mail).get();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User with id " + id));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User save(User user){
        LOGGER.info("Saving user");
        user.setCreationDate(new Date());
        user.setModificationDate(new Date());
        return userRepository.save(user);
    }

    /**
     * Update user information by admin
     * @param user
     * @param current
     * @return
     * @throws NotFoundException
     */
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
        user.setModificationDate(new Date());
        user.setPermitNum(current.getPermitNum());
        return userRepository.save(user);
    }

    /**
     * Update the user profile
     * @param id
     * @param current
     * @return
     * @throws NotFoundException
     */
    @Override
    public User updateProfile(Long id, UserDto current) throws NotFoundException {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User with id " + id));
        existingUser.setAddress(current.getAddress());
        existingUser.setFirstName(current.getFirstName());
        existingUser.setLastName(current.getLastName());
        existingUser.setBirthDay(current.getBirthDay());
        existingUser.setModificationDate(new Date());
        existingUser.setPermitNum(current.getPermitNum());
        return userRepository.save(existingUser);
    }

    @Override
    public boolean isUserExist(String mail) throws NotFoundException {
        return getByMail(mail) != null;
    }

    @Override
    public boolean isAdmin(Long id, String mail) throws NotFoundException {
        return userRepository.findByIdAndMail(id,mail) != null;
    }
}

