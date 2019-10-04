package com.motus.emotion.security;
import com.motus.emotion.exception.NotFoundException;
import com.motus.emotion.model.User;
import com.motus.emotion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByMail(username)
                .orElseThrow(() -> new UsernameNotFoundException("The User with user name : " + username + " not found"));
        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) throws NotFoundException {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("not found")
        );
        return UserPrincipal.create(user);
    }
}