package com.ucmed.hnust.thred;

/**
 * Created by ZY-LJ-1446 on 2018/12/11.
 */
public class Runnable48_1 implements Runnable {

    private ThreadDomain48 td;
    public Runnable48_1(ThreadDomain48 td) {
        this.td = td;
    }

    @Override
    public void run() {
        td.read();
    }
}
