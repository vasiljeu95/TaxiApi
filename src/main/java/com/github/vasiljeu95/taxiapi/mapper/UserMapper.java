package com.github.vasiljeu95.taxiapi.mapper;

import com.github.vasiljeu95.taxiapi.dto.NewUserDto;
import com.github.vasiljeu95.taxiapi.entity.user.User;

import java.util.List;

/**
 * UserMapper
 *
 * @author Stepan Vasilyeu
 * @since 07.07.2022
 */
public interface UserMapper {
    NewUserDto toUserDTO(User user);
    User toUser(NewUserDto userDTO);
    List<NewUserDto> toUserDTOList(List<User> users);
}
