package com.laolang.notespring.aopone;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {

    private static List<String> specialClientList = new ArrayList<String>();

    static {
        specialClientList.add("John");
        specialClientList.add("Tom");
    }

    /**
     * 对类进行静态切点检查
     * @return
     */
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                System.out.println("调用 getClassFilter()对"+aClass.getName() + "做静态检查.");
                return Waiter.class.isAssignableFrom(aClass);
            }
        };
    }

    /**
     * 对方法进行静态切点检查
     * @param method
     * @param targetClass
     * @return
     */
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("调用matches(Method,Class)"+targetClass.getName()+"."+method.getName()+"做静态检查");
        return "greetTo".equals(method.getName());
    }

    /**
     * 对方法进行动态方法检查
     * @param method
     * @param aClass
     * @param objects
     * @return
     */
    @Override
    public boolean matches(Method method, Class<?> aClass, Object[] objects) {
        System.out.println("调用matches(Method,Class,Object)"+aClass.getName()+"."+method.getName()+"做动态检查");
        String clientName = (String) objects[0];
        return specialClientList.contains(clientName);
    }
}
