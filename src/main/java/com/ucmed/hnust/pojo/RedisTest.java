package com.ucmed.hnust.pojo;

import java.io.Serializable;

/**
 * Created by ZY-LJ-1446 on 2018/3/29.
 */
public class RedisTest implements Serializable{
    private static final long serialVersionUID = -5244288298702801619L;
    private int id;
    private String userName;
    private String sex;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "RedisTest{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
