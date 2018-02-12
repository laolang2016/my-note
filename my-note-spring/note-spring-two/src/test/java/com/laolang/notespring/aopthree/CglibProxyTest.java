package com.laolang.notespring.aopthree;


import com.laolang.notespring.aoptwo.ForumServiceImpl;
import org.junit.Test;

public class CglibProxyTest {

    @Test
    public void cglibTest(){
        CglibProxy proxy = new CglibProxy();
        ForumServiceImpl forumService = (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);
        forumService.removeTopic(10);
        forumService.removeForum(20);
    }
}
