package com.example.clone.util;

import org.mindrot.jbcrypt.BCrypt;

/**
 * PasswordEncryptor애가 빈으로 등록되어야할가?
 * thread-safe하다고 생각한다  멀티스레드에서 사용한다고해서 영향받을 연산이 없는것같다.
 * 왜 암호화 알고리즘 중 SHA-256을 선택했는가?
 */


public class PasswordEncryptor{

    public String encrypt(String password){
        String encryptPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        return encryptPassword;
    }

    public boolean isMatch(String password, String hashPassword){
        return BCrypt.checkpw(password, hashPassword);
    }
}
