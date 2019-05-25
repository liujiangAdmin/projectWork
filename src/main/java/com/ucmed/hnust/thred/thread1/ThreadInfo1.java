package com.ucmed.hnust.thred.thread1;

import com.ucmed.hnust.pojo.Dept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Administrator on 2019/5/4 0004.
 */
public class ThreadInfo1 {

    private Dept dept;

    private String a = "1";
    private int sum = 0;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public ThreadInfo1(Dept dept) {
        this.dept = dept;
    }

    public ThreadInfo1() {
    }

    private ArrayList<String> list;

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    private HashMap<String,String>hashMap;

    public HashMap<String, String> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    public synchronized void show() {
        try {
            System.out.println(Thread.currentThread().getName() + "我进来了" + dept.getDeptName());
            dept.setDeptName("aaaaaaaaaaaaaaaaaaaaaaaa");
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "我出去了" + dept.getDeptName());
    }

    public synchronized void show1() {
        try {
            System.out.println(Thread.currentThread().getName() + "我进来了" + a);
            a = "2";
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "我出去了" + a);
    }

    public synchronized void show2() {
        sum = 0;
        System.out.println(Thread.currentThread().getName() + "我进来了" + sum);
        try {
            Thread.sleep(1000);
            for (int i = 1; i < 10100; i++) {
                sum = sum + i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "我出去了" + sum);
    }

    public synchronized void show3(String b) {
        try {
            System.out.println(Thread.currentThread().getName() + "我进来了");
            if (b.equals("x")) {
                a = "111";
            } else {
                a = "222";
            }
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "我出去了" + a);
    }

    public synchronized void show4() {
        System.out.println(Thread.currentThread().getName() + "我进来了"+list.size());
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        System.out.println(Thread.currentThread().getName() + "我出去了" + list.size());
    }

    public synchronized void show5() {
        //System.out.println(Thread.currentThread().getName() + "我进来了"+hashMap.size());
        int data = new Random().nextInt();
        hashMap.put(String.valueOf(data),String.valueOf(data));
        //System.out.println(Thread.currentThread().getName() + "我出去了" + hashMap.size());
    }

    public  void show6() {
        System.out.println(Thread.currentThread().getName() + "我进来了"+hashMap.size());
        int data = new Random().nextInt()+10086;
        hashMap.put(String.valueOf(data),String.valueOf(data));
        System.out.println(Thread.currentThread().getName() + "我出去了" + hashMap.size());

    }
}
