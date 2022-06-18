package com.example.clone.controller;


import com.example.clone.dto.UserDto;
import com.example.clone.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Ful 하게 URI를 설계하자 (리소스)
 * 메소드 네임 = 동사 + (명사, 목적어)
 * ResponseEntity를 사용하는것은 헤더까지 조작가능하기때문이다
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    // signup에서 이미존재하는 회원이면 false, 존재하지 않으면 true 요청메시지 매우중요
    @PostMapping("/signup")
    public void createUser(@RequestBody UserDto userDto){
        log.info("sign up handler execute");
        userService.signup(userDto);
    }



}
