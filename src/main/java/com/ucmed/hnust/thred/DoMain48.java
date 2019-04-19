package com.ucmed.hnust.thred;

/**
 * Created by ZY-LJ-1446 on 2018/12/11.
 */
public class DoMain48 {
    public static void main(String[] args) {
        ThreadDomain48 td = new ThreadDomain48();
        Thread t0 = new Thread(new Runnable48_1(td));
        Thread t1 = new Thread(new Runnable48_2(td));
        t0.start();
        t1.start();
    }
}
