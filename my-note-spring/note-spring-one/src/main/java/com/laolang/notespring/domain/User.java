package com.laolang.notespring.domain;

import java.util.*;

public class User {


    public User() {
    }

    public User(Integer id, String nickName, Integer age) {
        this.id = id;
        this.nickName = nickName;
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", nickName='" + nickName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                ", number=" + number +
                ", userInfo=" + userInfo +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserInfo getInfo() {
        return info;
    }

    public void setInfo(UserInfo info) {
        this.info = info;
    }

    public List<String> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<String> infoList) {
        this.infoList = infoList;
    }

    public Set<String> getInfoSet() {
        return infoSet;
    }

    public void setInfoSet(Set<String> infoSet) {
        this.infoSet = infoSet;
    }

    public Map<String, String> getInfoMap() {
        return infoMap;
    }

    public void setInfoMap(Map<String, String> infoMap) {
        this.infoMap = infoMap;
    }

    public Properties getEmails() {
        return emails;
    }

    public void setEmails(Properties emails) {
        this.emails = emails;
    }

    private Properties emails = new Properties();

    private Map<String , String> infoMap;

    private Set<String> infoSet = new HashSet<>();

    private List<String> infoList = new ArrayList<>();

    private UserInfo info = new UserInfo();

    private Integer id;

    private String userCode;

    private String nickName;

    private String pwd;

    private Integer age;

    private Integer number;

    private UserInfo userInfo;




}
