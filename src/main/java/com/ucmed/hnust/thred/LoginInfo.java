package com.ucmed.hnust.thred;

/**
 * Created by Administrator on 2019/5/3 0003.
 */
public class LoginInfo {

    private String name="";

    private String password="";

    private int num = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginInfo(){

    }
    public LoginInfo(String name,String password){
        this.name = name;
        this.password = password;
    }

    public synchronized void show() {
        System.out.println("show");

        System.out.println(name+password);
    }

    public synchronized void show1(String name1,String password1) {
        System.out.println("into");
       name = name1;
       password = password1;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       System.out.println(name+password);
    }

    public synchronized   void addNum(String userName)
    {
        try
        {
            if ("a".equals(userName))
            {
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            }
            else
            {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(userName + " num = " + num);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
