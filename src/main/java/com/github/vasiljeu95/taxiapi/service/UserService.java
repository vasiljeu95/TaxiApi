package com.github.vasiljeu95.taxiapi.service;

import com.github.vasiljeu95.taxiapi.entity.user.User;

import java.util.List;

public interface UserService {
    User userRegistr(User user);
    User driverRegistr(User user);
    List<User> getAll();
    User findByUsername (String username);
    User findById (Long id);
    void delete (Long id);
}
