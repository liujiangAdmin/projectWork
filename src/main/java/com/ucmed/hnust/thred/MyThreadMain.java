package com.ucmed.hnust.thred;

/**
 * Created by ZY-LJ-1446 on 2018/12/10.
 */
public class MyThreadMain {
    public static void main(String[] args) {
        ThreadDomain39 td = new ThreadDomain39();
        MyThread39_0 mt0 = new MyThread39_0(td);
        MyThread39_1 mt1 = new MyThread39_1(td);
        mt0.start();
        mt1.start();


    }
}
