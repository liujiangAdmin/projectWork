package com.ucmed.hnust.thred.thread1;

/**
 * Created by Administrator on 2019/5/3 0003.
 */
public class ThreadRunable1_2 implements Runnable {

    private ThreadInfo1 threadInfo1;

    public ThreadRunable1_2(ThreadInfo1 threadInfo1) {
        this.threadInfo1 = threadInfo1;
    }

    @Override
    public void run() {

        //threadInfo1.show3("y");
        threadInfo1.show6();
    }
}
