package com.example.clone.dto;

import com.example.clone.util.PasswordEncryptor;
import com.example.clone.util.UserLevel;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * given
 * when
 * then
 */
class UserDtoTest {

    PasswordEncryptor encryptor = new PasswordEncryptor();

    @Test
    void memberDto(){
        UserDto userDto = UserDto.builder()
                .id("icwgi897")
                .password("1234")
                .level(UserLevel.USER)
                .build();

        assertThat("icwgi897").isEqualTo(userDto.getId());
    }

    @Test
    void passwordEncrypt(){
        String password = "1234";
        String encrypt = encryptor.encrypt(password);
        System.out.println("password = " + password + " encrypt = "+ encrypt);
        assertThat(encrypt).isNotEqualTo(password);
    }

    @Test
    void passwordMatch(){
        String password = "1234";
        String encryptPassword = encryptor.encrypt(password);
        boolean match = encryptor.isMatch(password, encryptPassword);
        System.out.println(match);
        assertThat(match).isEqualTo(true);
    }



}