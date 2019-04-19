package com.ucmed.hnust.thred;

/**
 * Created by ZY-LJ-1446 on 2018/12/11.
 */
public class Runnable48_2 implements Runnable{
    private ThreadDomain48 td;
    public Runnable48_2(ThreadDomain48 td) {
        this.td = td;
    }

    @Override
    public void run() {
        td.write();
    }
}
