package com.github.vasiljeu95.taxiapi.controller;

import com.github.vasiljeu95.taxiapi.dto.AdminUserDto;
import com.github.vasiljeu95.taxiapi.dto.UserDto;
import com.github.vasiljeu95.taxiapi.entity.user.User;
import com.github.vasiljeu95.taxiapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AdminRestController
 *
 * @author Stepan Vasilyeu
 * @since 07.07.2022
 */
@RestController
@RequestMapping(value = "/api/admin/")
public class AdminRestController {
    private final UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "usersById/{id}")
    public ResponseEntity<AdminUserDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        AdminUserDto result = AdminUserDto.fromUser(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "usersByUsername/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable(name = "username") String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        UserDto result = UserDto.fromUser(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
