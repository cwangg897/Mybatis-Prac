package com.example.clone.mapper;

import com.example.clone.dto.UserDto;

import java.util.Optional;

public interface UserMapper {

    void insertUser(UserDto userDto);

    Optional<UserDto> findById(String id);

    boolean isExistId(String id);

    Optional<UserDto> findUserByIdAndPassword(String id, String password);


}
