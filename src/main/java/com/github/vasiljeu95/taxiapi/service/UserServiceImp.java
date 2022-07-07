package com.github.vasiljeu95.taxiapi.service;

import com.github.vasiljeu95.taxiapi.entity.Role;
import com.github.vasiljeu95.taxiapi.entity.Status;
import com.github.vasiljeu95.taxiapi.entity.User;
import com.github.vasiljeu95.taxiapi.repository.RoleRepository;
import com.github.vasiljeu95.taxiapi.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * UserServiceImplementation
 *
 * @author Stepan Vasilyeu
 * @since 07.07.2022
 */
@Service
@Slf4j
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User userRegistr(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);
        Date now = new Date();

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoleList(userRoles);
        user.setStatus(Status.ACTIVE);
        user.setCreated(now);
        user.setUpdated(now);

        User registeredUser = userRepository.save(user);

        log.info("IN register - user: {} successfully registered", registeredUser);

        return registeredUser;
    }

    @Override
    public User driverRegistr(User user) {
        Role roleUser = roleRepository.findByName("ROLE_DRIVER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);
        Date now = new Date();

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoleList(userRoles);
        user.setStatus(Status.ACTIVE);
        user.setCreated(now);
        user.setUpdated(now);

        User registeredUser = userRepository.save(user);

        log.info("IN register - user: {} successfully registered", registeredUser);

        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        log.info("IN getAll - {} users found", result.size());
        return result;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByUsername(username);
        log.info("IN findByUsername - user: {} found by username: {}", result.getUsername(), username);
        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);
        if (result == null) {
            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }
        log.info("IN findById - user: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully deleted", id);
    }

    public boolean existByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

}
