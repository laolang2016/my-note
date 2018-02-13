package com.laolang.notespring.aopfour;

import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class AdviceTest {


    @Test
    public void methodBeforeAdviceTest(){
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();

        // spring 提供的代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        // 设置代理目标
        proxyFactory.setTarget(target);
        // 为代理目标添加增强
        proxyFactory.addAdvice(advice);

        // 生成代理实例
        Waiter proxy = (Waiter) proxyFactory.getProxy();
        proxy.greetTo("xiaodaima");
        proxy.serveTo("laolang");
    }

    @Test
    public void methodBeforeAdviceTest02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-test-contest.xml");
        Waiter waiter = (Waiter) context.getBean("waiter");
        waiter.greetTo("xiaodaima");
    }

    @Test
    public void methodInterceptorTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-test-contest.xml");
        Waiter waiter = (Waiter) context.getBean("waiter2");
        waiter.greetTo("laolang");
    }

    @Test(expected = SQLException.class)
    public void throsAdviceTest() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-test-contest.xml");
        ForumService forumService = (ForumService) context.getBean("forumService");
    //        forumService.removeForum(1);
        forumService.updateForum(null);
    }

    @Test
    public void delegatingIntroductionInterceptorTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-test-contest.xml");
        com.laolang.notespring.aoptwo.ForumService forumService = (com.laolang.notespring.aoptwo.ForumService) context.getBean("forumService2");
        // 默认未开启性能监视功能
        forumService.removeTopic(10);
        forumService.removeForum(20);

        System.out.println("------------");

        // 开启性能监视功能
        Monitorable monitorable = (Monitorable) forumService;
        monitorable.setMonitorActive(true);

        forumService.removeTopic(10);
        forumService.removeForum(20);
    }

}
