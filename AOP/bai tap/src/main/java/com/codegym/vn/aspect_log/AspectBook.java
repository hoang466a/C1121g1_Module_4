package com.codegym.vn.aspect_log;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AspectBook {
    @AfterReturning(pointcut = "execution(public * com.codegym.vn.controller.BookController.borrowBook(..))||" +
            "execution(public * com.codegym.vn.controller.BookController.returnBook(..))")

    public void logUpdateBook(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.err.println("Method name: " + methodName);
        System.err.println("Args: " + args);
    }

    @AfterReturning(pointcut = "execution(public * com.codegym.vn.controller.BookController.*(..))")
    public void logController(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.err.println("Method name: " + methodName);
        System.err.println("Args: " + args);
    }
}
