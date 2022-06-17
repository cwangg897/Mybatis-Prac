package com.example.clone.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataBaseConfigTest {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Test
    void 연결_테스트(){
        System.out.println("---------------------------------");
        System.out.println(sqlSessionFactory.openSession());
        System.out.println("---------------------------------");
    }

}