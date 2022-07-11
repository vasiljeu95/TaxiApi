package com.github.vasiljeu95.taxiapi.service;

import com.github.vasiljeu95.taxiapi.configuration.jwt.JwtUser;
import com.github.vasiljeu95.taxiapi.configuration.jwt.JwtUserFactory;
import com.github.vasiljeu95.taxiapi.entity.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * JWTUserDetailsService
 *
 * @author Stepan Vasilyeu
 * @since 07.07.2022
 */
@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("IN loadUserByUsername - user with username: {} - successfully loaded", username);
        return jwtUser;
    }
}
