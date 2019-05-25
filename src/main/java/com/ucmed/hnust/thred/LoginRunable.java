package com.ucmed.hnust.thred;

/**
 * Created by Administrator on 2019/5/3 0003.
 */
public class LoginRunable implements Runnable {

    private LoginInfo loginInfo;

    public LoginRunable(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    @Override
    public void run() {

        loginInfo.show();
        //loginInfo.show1("liujiang","123456");
        //loginInfo.addNum("a");
    }
}
