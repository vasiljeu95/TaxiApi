package com.github.vasiljeu95.taxiapi.dto;

import lombok.Data;

/**
 * AuthenticationRequestDto
 *
 * @author Stepan Vasilyeu
 * @since 07.07.2022
 */
@Data
public class AuthenticationRequestDto {
    private String username;
    private String password;
}
