package com.example.clone.dto;

import com.example.clone.util.UserLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 고객의 종류가 여러가지라서 UserLevel을 주었습니다.
 * mysql member 예약어 이슈
 */
@NoArgsConstructor
@Getter
public class UserDto {

    private String id;

    private String password;

    private UserLevel level;

    @Builder
    public UserDto(String id, String password, UserLevel level){
        this.id = id;
        this.password = password;
        this.level = level;
    }

}
