package com.laolang.notespring.domain;

public class UserInfo {

    public UserInfo() {
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", info='" + info + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private Integer id;

    private Integer userId;

    private String info;
}
