package com.laolang.notespring.aopone;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PointcutTestOne {

    @Test
    public void staticMethodMatcherPointcutAdvisorTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-test-context.xml");
        Waiter waiter = (Waiter) context.getBean("waiter");
        Seller seller = (Seller) context.getBean("seller");
        waiter.greetTo("laolang");
        waiter.serveTo("laolang");
        seller.greetTo("laolang");
    }

    @Test
    public void regexpMethodPointcutAdvisorTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-test-context.xml");
        Waiter waiter = (Waiter) context.getBean("waiter1");
        waiter.greetTo("laolang");
        waiter.serveTo("laolang");
    }

    @Test
    public void dynamicMethodMatcherPointcutTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-test-context.xml");
        Waiter waiter = (Waiter) context.getBean("waiter2");
        waiter.serveTo("Peter");
        waiter.greetTo("Peter");
        waiter.serveTo("John");
        waiter.greetTo("John");
    }

    @Test
    public void aspectTest01(){
        IWaiter target = new WaiterImpl();

        AspectJProxyFactory factory = new AspectJProxyFactory();

        // 设置目标对象
        factory.setTarget(target);

        // 添加切面类
        factory.addAspect(PreGreetingAspect.class);

        // 生成织入切面的代理对象
        IWaiter proxy = factory.getProxy();

        proxy.greetTo("laolang");
        proxy.serveTo("laolang");
    }

    @Test
    public void aspectTest02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-test-context.xml");
        IWaiter waiter = (IWaiter) context.getBean("waiter4");
        waiter.greetTo("laolang");
        waiter.serveTo("laolang");
    }
}
