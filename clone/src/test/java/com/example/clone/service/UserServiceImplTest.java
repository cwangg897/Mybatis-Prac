package com.example.clone.service;

import com.example.clone.dto.UserDto;
import com.example.clone.excpetion.ExistException;
import com.example.clone.util.UserLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    @DisplayName("이미 존재하는 아이디")
    void isExistId() {
        UserDto userDto = UserDto.builder()
                .id("icwgi897")
                .password("1234")
                .level(UserLevel.USER)
                .build();

        ExistException existException = Assertions.assertThrows(ExistException.class, () -> {
            userService.signup(userDto);
        });
        System.out.println(existException.getMessage());
    }


}