package com.example.clone.service;

import com.example.clone.dto.UserDto;
import com.example.clone.excpetion.ExistException;
import com.example.clone.mapper.UserMapper;
import com.example.clone.util.PasswordEncryptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    /**
     * return 값으로 boolean 타입을 반환해야하는가?
     */
    @Override
    public void signup(UserDto userDto) {
        log.info("UserService signup execute");
        if(userMapper.isExistId(userDto.getId())){
            throw new ExistException("Existed id =" +userDto.getId());
        }
        // 비밀번호 암호화
        String passwordEncrypt = passwordEncrypt(userDto.getPassword());

        UserDto insertUser = UserDto.builder()
                .id(userDto.getId())
                .password(passwordEncrypt)
                .level(userDto.getLevel())
                .build();
        userMapper.insertUser(insertUser);
    }

    @Override
    public void login(UserDto userDto) {
        Optional<UserDto> findUser = userMapper.findUserByIdAndPassword(userDto.getId(), passwordEncrypt(userDto.getPassword()));
        if(findUser == null){
            throw new RuntimeException("존재하지 않는 아이디입니다");
        }
    }


    public String passwordEncrypt(String password){
        PasswordEncryptor encryptor = new PasswordEncryptor();
        return encryptor.encrypt(password);
    }

    public boolean passwordMatch(String password){
        PasswordEncryptor encryptor = new PasswordEncryptor();
        return encryptor.isMatch(password, encryptor.encrypt(password));
    }






}
