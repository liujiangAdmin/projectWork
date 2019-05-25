package com.ucmed.hnust.thred;

/**
 * Created by Administrator on 2019/5/3 0003.
 */
public class LoginRunable1 implements Runnable {

    private LoginInfo loginInfo;

    public LoginRunable1(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    @Override
    public void run() {

        loginInfo.show();
        //loginInfo.show1("weixiangyang","456789");
        //loginInfo.addNum("b");
    }
}
