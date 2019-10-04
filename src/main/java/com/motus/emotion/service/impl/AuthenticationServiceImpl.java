package com.motus.emotion.service.impl;

import com.motus.emotion.dto.AuthDto;
import com.motus.emotion.dto.UserDto;
import com.motus.emotion.exception.AlreadyExistException;
import com.motus.emotion.exception.NotFoundException;
import com.motus.emotion.model.Role;
import com.motus.emotion.model.RoleName;
import com.motus.emotion.model.User;
import com.motus.emotion.repository.RoleRepository;
import com.motus.emotion.security.jwt.JwtProvider;
import com.motus.emotion.service.AuthenticationService;
import com.motus.emotion.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Collections;
@Service(value = "authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {
    private final Logger LOGGER = LoggerFactory.getLogger(AuthenticationService.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JwtProvider jwtProvider;

    /**
     * Sign in a user into the application, with JWT-enabled authentication
     *
     * @param authDto Object that contains authentications
     * @return String Token
     */
    @Override
    public String authenticateJwt(AuthDto authDto) throws NotFoundException {
        LOGGER.info("New user attempting to sign in");
        String token = null;
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword()));
            token = jwtProvider.generateToken(authentication);
            LOGGER.info("Log in failed for user {}", authDto.getUsername());
        return token;
    }

    @Override
    public User signUp(UserDto userDto) throws AlreadyExistException, NotFoundException {
        if (userService.isUserExist(userDto.getMail())) {
            LOGGER.error("Unable to create. A User with username {} it already exists", userDto.getMail());
            throw new AlreadyExistException("User already exist");
        }
        User user = new User(userDto);
        Role userRole = roleRepository.findByRoleName(RoleName.USER_ROLE);
        user.setRoles(Collections.singleton(userRole));

        return userService.save(user);
    }
}
