package com.laolang.notespring.aopone;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * 切面
 * 静态方法匹配器切点定义的切面
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {


    /**
     * 切点方法匹配规则：方法名为：greetTo
     * @param method
     * @param aClass
     * @return
     */
    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return "greetTo".equals(method.getName());
    }

    /**
     * 通过覆盖 getClassFilter ，仅匹配Waiter类及其子类
     * 匹配规则：为Waiter的类或子类
     * @return
     */
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                // 判断 Waiter 是否与clazz的类或接口相同
                // 或Waiter是否为clazz的超类或超接口
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }
}
