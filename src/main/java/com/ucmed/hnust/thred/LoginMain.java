package com.ucmed.hnust.thred;

/**
 * Created by Administrator on 2019/5/3 0003.
 */
public class LoginMain {
    public static void main(String[] args) {

        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setName("liujiang");
        loginInfo.setPassword("123456");
        Thread a = new Thread(new LoginRunable(loginInfo));
        a.start();

        loginInfo.setName("weixiangyang");
        loginInfo.setPassword("456789");
        Thread b = new Thread(new LoginRunable1(loginInfo));
        b.start();

        /*LoginInfo loginInfo = new LoginInfo();
        MyThread39_0 mt0 = new MyThread39_0(loginInfo);
        mt0.start();
        MyThread39_1 mt1 = new MyThread39_1(loginInfo);
        mt1.start();*/
    }
}
