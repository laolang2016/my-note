package com.laolang.notespring.aoptwo;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class ForumServiceTest {

    @Test
    public void forumServiceAopByJdkTest(){
        // 希望被代理的目标业务类
        ForumService target = new ForumServiceImpl();

        // 根据编制了目标业务类逻辑和性能监视横切逻辑的InvocationHandler示例创建代理示例
        PerformanceHandler handler = new PerformanceHandler(target);
        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),handler);

        // 调用代理实例
        proxy.removeTopic(10);
        proxy.removeForum(20);
    }
}
