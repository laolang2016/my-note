package com.laolang.notespring.factory;

import com.laolang.notespring.domain.User;

public class UserStaticFactory {

    public static User createUser(){
        User user = new User();
        user.setId(1003);
        user.setNickName("laolang");
        return user;
    }

    public static User createUser( Integer id, String nickName ){
        User user = new User();
        user.setId(id);
        user.setNickName(nickName);
        return user;
    }
}
