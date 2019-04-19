package com.ucmed.hnust.thred;

/**
 * Created by ZY-LJ-1446 on 2018/12/10.
 */
public class MyThread39_1 extends Thread
{
    private ThreadDomain39 td;

    public MyThread39_1(ThreadDomain39 td)
    {
        this.td = td;
    }

    public void run()
    {
        td.methodB();
    }
}
