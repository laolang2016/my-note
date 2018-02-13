package com.laolang.notespring.aopfour;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // 目标方法入参
        Object[] args = methodInvocation.getArguments();
        String clientName = (String) args[0];

        // 在目标方法执行前调用
        System.out.println("How are you! Mr." + clientName+".");

        // 通过反射机制调用目标方法
        Object o = methodInvocation.proceed();

        // 在目标方法执行后调用
        System.out.println("Please enjoy yourself!");

        return o;
    }
}
