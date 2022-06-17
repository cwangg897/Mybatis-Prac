package com.example.clone;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


class CloneApplicationTests {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Test
    void contextLoads() {
        System.out.println(driverClassName);
    }

}
