package com.laolang.notespring.aopone;

import org.junit.Test;

public class ForumServiceTest {

    @Test
    public void forumServiceAopTest(){
        ForumService forumService = new ForumServiceImpl();
        forumService.removeTopic(10);
        forumService.removeForum(20);
    }

    public void forumServiceAopByJdkTest(){

    }
}
