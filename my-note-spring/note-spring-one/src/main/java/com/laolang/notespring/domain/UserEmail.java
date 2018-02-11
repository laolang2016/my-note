package com.laolang.notespring.domain;

public class UserEmail {

    public UserEmail() {
    }

    @Override
    public String toString() {
        return "UserEmail{" +
                "id=" + id +
                ", userId=" + userId +
                ", email='" + email + '\'' +
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private Integer id;

    private Integer userId;

    private String email;
}
