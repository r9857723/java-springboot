package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.example.demo.HpPrinter.*(..))")
    public void before() {
        System.out.println("I'm before.");
    }

    @After("execution(* com.example.demo.HpPrinter.*(..))")
    public void after() {
        System.out.println("I'm after.");
    }


    @Around("execution(* com.example.demo.HpPrinter.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("I'm around before.");

        Object obj = pjp.proceed();

        System.out.println("I'm around after");
        return obj;
    }
}
