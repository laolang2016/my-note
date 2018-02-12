package com.laolang.notespring.aoptwo;



import com.laolang.notespring.aopone.PerformanceMonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceHandler implements InvocationHandler {

    // 被代理的目标对象
    private Object target;

    public PerformanceHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy 最终生成的代理示例，一般不会用到
     * @param method 被代理目标示例的某个具体方法，通过它可以发起目标示例方法的反射调用
     * @param args 被代理示例某个方法的入参
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName()+". "+method.getName());
        Object obj = method.invoke(target,args);
        PerformanceMonitor.end();
        return obj;
    }
}
