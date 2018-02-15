package com.laolang.notespring.aopone;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 前置增强
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName() + "." + method.getName());
        String clientName = (String) objects[0];
        System.out.println("How are you! Mr."+clientName+".");
    }
}
