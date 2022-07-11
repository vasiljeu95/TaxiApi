package com.github.vasiljeu95.taxiapi.mapper;

import com.github.vasiljeu95.taxiapi.dto.NewUserDto;
import com.github.vasiljeu95.taxiapi.entity.user.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * UserMapperImpl
 *
 * @author Stepan Vasilyeu
 * @since 07.07.2022
 */
@Component
public class UserMapperImpl implements UserMapper{
    @Override
    public NewUserDto toUserDTO(User user) {
        return null;
    }

    @Override
    public User toUser(NewUserDto userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setFirstname(userDTO.getFirstName());
        user.setLastname(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return user;
    }

    @Override
    public List<NewUserDto> toUserDTOList(List<User> users) {
        return null;
    }
}
