package com.ucmed.hnust.thred;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by ZY-LJ-1446 on 2018/12/11.
 */
public class ThreadDomain48 extends ReentrantReadWriteLock {

    public void write() {
        try {
            writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "获得了写锁, 时间为" +
                    System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock().unlock();
        }
    }

    public void read() {
        try {
            readLock().lock();
            System.out.println(Thread.currentThread().getName() + "获得了读锁, 时间为" +
                    System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock().unlock();
        }
    }
}
