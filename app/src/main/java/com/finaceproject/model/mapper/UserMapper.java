package com.finaceproject.model.mapper;

import com.finaceproject.model.dao.User;
import com.finaceproject.model.dto.UserDto;

public class UserMapper implements Mapper<UserDto, User>{
    @Override
    public User toDao(UserDto userDto) {
        return new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(),
                userDto.getLogin(), userDto.getPassword());
    }

    @Override
    public UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(),
                user.getLogin(), user.getPassword());
    }
}
