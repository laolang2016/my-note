package com.laolang.notespring.factory;

import com.laolang.notespring.domain.User;
import org.springframework.beans.factory.FactoryBean;

public class UserFactoryBean implements FactoryBean<User> {

    public String getUserInfo() {
        return userInfo;
    }

    // 接收逗号分隔的属性值
    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    private String userInfo;

    // 实例化 bean
    @Override
    public User getObject() throws Exception {
        User user = new User();
        String[] infos = userInfo.split(",");
        user.setId(Integer.valueOf(infos[0]));
        user.setUserCode(infos[1]);
        user.setNickName(infos[2]);
        return user;
    }

    // 返回 bean 类型
    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    // 通过该标示确定是否为单利
    @Override
    public boolean isSingleton() {
        return true;
    }
}
