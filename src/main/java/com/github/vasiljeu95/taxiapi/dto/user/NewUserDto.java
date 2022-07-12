package com.github.vasiljeu95.taxiapi.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.vasiljeu95.taxiapi.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * NewUserDto
 *
 * @author Stepan Vasilyeu
 * @since 07.07.2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewUserDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
}

