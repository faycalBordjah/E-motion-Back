package com.motus.emotion.service;

import com.motus.emotion.dto.AuthDto;
import com.motus.emotion.dto.UserDto;
import com.motus.emotion.exception.AlreadyExistException;
import com.motus.emotion.exception.NotFoundException;
import com.motus.emotion.model.User;
import org.springframework.stereotype.Service;

public interface AuthenticationService {

String authenticateJwt(AuthDto authDto) throws AlreadyExistException, NotFoundException;
User signUp(UserDto userDto) throws AlreadyExistException, NotFoundException;
}
