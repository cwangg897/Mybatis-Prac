package com.example.clone.controller;

import com.example.clone.dto.UserDto;
import com.example.clone.util.UserLevel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("이미 존재하는거 회원가입 성공")
    void signup_success() throws Exception {
        UserDto userDto = UserDto.builder()
                .id("icwgi897")
                .password("1234")
                .level(UserLevel.USER)
                .build();

        String reqeust = objectMapper.writeValueAsString(userDto);
        System.out.println(reqeust);
        mockMvc.perform(post("/signup")
                        .content(reqeust).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("이미 존재하는거 회원가입 실패")
    void signup_fail() throws Exception {
        UserDto userDto = UserDto.builder()
                .id("icwgi897")
                .password("1234")
                .level(UserLevel.USER)
                .build();

        // 테스트 하기어려운이유가 애초에 서버로 예외메시지를 가져와야하는데
        String reqeust = objectMapper.writeValueAsString(userDto);
        System.out.println(reqeust);
        // 질문하기
//        mockMvc.perform(post("/signup")
//                        .content(reqeust).contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isInternalServerError());
    }

}