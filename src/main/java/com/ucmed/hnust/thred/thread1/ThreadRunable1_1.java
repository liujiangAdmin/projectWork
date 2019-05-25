package com.ucmed.hnust.thred.thread1;

import com.ucmed.hnust.thred.LoginInfo;

/**
 * Created by Administrator on 2019/5/3 0003.
 */
public class ThreadRunable1_1 implements Runnable {

    private ThreadInfo1 threadInfo1;

    public ThreadRunable1_1(ThreadInfo1 threadInfo1) {
        this.threadInfo1 = threadInfo1;
    }

    @Override
    public void run() {

        //threadInfo1.show2();
        //threadInfo1.show3("x");
        //threadInfo1.show4();
        threadInfo1.show5();
    }
}
