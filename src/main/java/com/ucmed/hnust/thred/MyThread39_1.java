package com.ucmed.hnust.thred;

/**
 * Created by ZY-LJ-1446 on 2018/12/10.
 */
public class MyThread39_1 extends Thread
{
    private LoginInfo loginInfo;

    public MyThread39_1(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    public void run()
    {
        //loginInfo.show();
        loginInfo.show1("weixiangyang","456789");
        //loginInfo.addNum("b");
    }
}
