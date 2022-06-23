package com.example.clone.aop;

import com.example.clone.annotation.TestAnnotation;
import com.example.clone.controller.UserController;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectTest {

    @Around("@annotation(com.example.clone.annotation.TestAnnotation) && @args(target)")
    public void test(TestAnnotation target) throws Throwable {
        System.out.println("시작");
        int value = target.value();
        System.out.println("value : "+value);
        System.out.println("끝");
    }

    @Before("@annotation(com.example.clone.annotation.TestAnnotation) && args(hey)")
    public void test_args(Object hey) throws Throwable {
        System.out.println("args 시작");
        Object hey1 = hey;
        System.out.println("args value : "+hey1);
        System.out.println("args 끝");
    }

    @Before("@annotation(com.example.clone.annotation.TestAnnotation2) && target(hey)")
    public void test_target(Object hey) throws Throwable {
        System.out.println("target 시작");
        UserController hey1 =(UserController) hey;
        ((UserController) hey).kiki();
        System.out.println("target value : "+hey1);
        System.out.println("target 끝");
    }

}
