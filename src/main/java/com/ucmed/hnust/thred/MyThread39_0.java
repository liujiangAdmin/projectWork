package com.ucmed.hnust.thred;

/**
 * Created by ZY-LJ-1446 on 2018/12/10.
 */
public class MyThread39_0 extends Thread
{
    private LoginInfo loginInfo;

    public MyThread39_0(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    public void run()
    {
        //loginInfo.show();
        loginInfo.show1("liujiang","123456");
        //loginInfo.addNum("a");
    }
}
