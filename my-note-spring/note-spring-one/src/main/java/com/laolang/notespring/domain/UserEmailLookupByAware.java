package com.laolang.notespring.domain;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class UserEmailLookupByAware implements ApplicationContextAware {

    private ApplicationContext context;

    public UserEmail getUserEmail(){
        return (UserEmail) context.getBean("userEmail");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
