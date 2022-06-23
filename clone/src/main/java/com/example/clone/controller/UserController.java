package com.example.clone.controller;


import com.example.clone.annotation.TestAnnotation;
import com.example.clone.annotation.TestAnnotation2;
import com.example.clone.dto.UserDto;
import com.example.clone.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
        log.info("sign up handler 실행");
        userService.signup(userDto);
    }

    @PostMapping("login")
    public void login(@RequestBody UserDto userDto, HttpServletRequest httpServletRequest){
        log.info("long handler 실행");
        userService.login(userDto);
        HttpSession session1 = httpServletRequest.getSession();
        if(session1.getAttribute("userId") == null){

        }
        session1.setAttribute("userId", userDto.getId());
    }

    @TestAnnotation(value = 10)
    @GetMapping("/test")
    public void test(){
        System.out.println("hello test");
    }


    @TestAnnotation
    @GetMapping("/args")
    public void test1(String hey){
        System.out.println("args 실행 컨트롤러");
    }

    @TestAnnotation2
    @GetMapping("/target")
    public void test2(String hey){
        System.out.println("target 컨트롤러 실행");
    }


    public void kiki(){
        System.out.println("웃어요");
    }



}
