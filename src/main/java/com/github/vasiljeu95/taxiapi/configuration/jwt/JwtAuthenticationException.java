package com.github.vasiljeu95.taxiapi.configuration.jwt;

import org.springframework.security.core.AuthenticationException;

/**
 * JwtAuthenticationException
 *
 * @author Stepan Vasilyeu
 * @since 07.07.2022
 */
public class JwtAuthenticationException extends AuthenticationException {
    public JwtAuthenticationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public JwtAuthenticationException(String msg) {
        super(msg);
    }
}
