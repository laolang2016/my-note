package com.laolang.notespring.po;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class DbInfo {

    public DbInfo() {
    }

    @Override
    public String toString() {
        return "DbInfo{" +
                "className='" + className + '\'' +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Value("${db.className}")
    private String className;

    @Value("${db.username}")
    private String username;

    @Value("${db.pwd}")
    private String pwd;

    @Value("${db.url}")
    private String url;
}
