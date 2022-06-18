package com.example.clone.mapper;

import com.example.clone.dto.UserDto;

public interface UserMapper {

    void insertUser(UserDto userDto);

    UserDto findById(String id);

    boolean isExistId(String id);




}
