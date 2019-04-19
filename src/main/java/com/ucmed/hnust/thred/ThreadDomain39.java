package com.ucmed.hnust.thred;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ZY-LJ-1446 on 2018/12/10.
 */
public class ThreadDomain39
{
    private Lock lock = new ReentrantLock();

    public void methodA()
    {
        try
        {
            lock.lock();
            System.out.println("MethodA begin ThreadName = " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("MethodA end ThreadName = " + Thread.currentThread().getName());
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            lock.unlock();
        }

    }

    public synchronized void methodB()
    {

        System.out.println("MethodB begin ThreadName = " + Thread.currentThread().getName());
        System.out.println("MethodB begin ThreadName = " + Thread.currentThread().getName());

    }
}
