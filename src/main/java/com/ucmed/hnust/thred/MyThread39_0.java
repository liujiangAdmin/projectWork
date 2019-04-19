package com.ucmed.hnust.thred;

/**
 * Created by ZY-LJ-1446 on 2018/12/10.
 */
public class MyThread39_0 extends Thread
{
    private ThreadDomain39 td;

    public MyThread39_0(ThreadDomain39 td)
    {
        this.td = td;
    }

    public void run()
    {
        td.methodA();
    }
}
