package com.ucmed.hnust.service;

/**
 * Created by ZY-LJ-1446 on 2018/9/29.
 */
public class IocXml {

    private int a;
    private String b;

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public int getA() {

        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void print()
    {
        System.out.println("a:"+a);
        System.out.println("b:"+b);
    }
}
