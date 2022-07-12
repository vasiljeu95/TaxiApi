package com.github.vasiljeu95.taxiapi.dto.user;

import lombok.Data;

/**
 * OrderByIdRequestDto
 *
 * @author Stepan Vasilyeu
 * @since 08.07.2022
 */
@Data
public class ByIdRequestDto {
    private String id;

    public Long getId() {
        String s = id;
        long l = Long.parseLong(s);
        return l;
    }
}
