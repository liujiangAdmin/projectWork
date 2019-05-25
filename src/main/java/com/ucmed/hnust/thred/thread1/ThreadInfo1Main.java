package com.ucmed.hnust.thred.thread1;

import com.ucmed.hnust.pojo.Dept;
import com.ucmed.hnust.thred.LoginInfo;
import com.ucmed.hnust.thred.LoginRunable;
import com.ucmed.hnust.thred.LoginRunable1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/5/3 0003.
 */
public class ThreadInfo1Main {
    public static void main(String[] args)  {

       try {
            /*Dept dept = new Dept();
        dept.setDeptName("aaaa");
        ThreadInfo1 threadInfo1 = new ThreadInfo1(dept);
        Thread a = new Thread(new ThreadRunable1_1(threadInfo1));
        Thread b = new Thread(new ThreadRunable1_1(threadInfo1));
        Thread c = new Thread(new ThreadRunable1_1(threadInfo1));
        Thread d = new Thread(new ThreadRunable1_1(threadInfo1));
        Thread e = new Thread(new ThreadRunable1_1(threadInfo1));
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();*/


        /*Dept dept1 = new Dept();
        dept1.setDeptName("aaaa");
        ThreadInfo1 threadInfo2 = new ThreadInfo1(dept1);
        ThreadInfo1 threadInfo3 = new ThreadInfo1(dept1);
        Thread f = new Thread(new ThreadRunable1_1(threadInfo2));
        Thread g = new Thread(new ThreadRunable1_1(threadInfo2));
        f.start();
        g.start();*/

        /*ThreadInfo1 threadInfo2 = new ThreadInfo1();
        Thread h = new Thread(new ThreadRunable1_1(threadInfo2));
        Thread i = new Thread(new ThreadRunable1_2(threadInfo2));
        h.start();
        i.start();*/

        /*ArrayList<String> list = new ArrayList<>();
        ThreadInfo1 threadInfo12 = new ThreadInfo1();
        threadInfo12.setList(list);
        Thread h = new Thread(new ThreadRunable1_1(threadInfo12));
        Thread i = new Thread(new ThreadRunable1_1(threadInfo12));
        h.start();
        i.start();*/

           HashMap<String,String> hashMap = new HashMap<>();
           ThreadInfo1 threadInfo12 = new ThreadInfo1();
           threadInfo12.setHashMap(hashMap);
           for (int ii = 0;ii<10000;ii++)
           {
               new Thread(new ThreadRunable1_1(threadInfo12)).start();
           }
           Thread.sleep(20000);
           System.out.println(hashMap.size());
           int sum = 0;
           for (Map.Entry<String, String> entry : hashMap.entrySet()) {
               //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
               if(entry.getKey()!= null && entry.getKey().equals(entry.getValue()))
               {
                   sum++;
                   //System.out.println("ng"+entry.getKey()+":"+entry.getValue());
               }else{
                   System.out.println("ng");
               }
           }
           System.out.println(sum);
       }catch (Exception e)
       {
           System.out.println(e);
       }


    }
}
