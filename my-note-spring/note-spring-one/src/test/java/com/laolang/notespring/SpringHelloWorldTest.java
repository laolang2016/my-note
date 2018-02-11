package com.laolang.notespring;

import com.laolang.notespring.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class SpringHelloWorldTest {

    @Test
    public void helloworldTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-test-public.xml");
        User user = (User) context.getBean("user");
        assertNotNull(user);
    }
}
