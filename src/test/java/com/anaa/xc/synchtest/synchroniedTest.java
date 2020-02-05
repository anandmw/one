package com.anaa.xc.synchtest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dell on 2020/2/3.
 */
public class synchroniedTest {


    public static void main(String[] args) {

        final Object someObject = new Object();

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(now()+this.getName()+"准备占有");
                    synchronized (someObject){
                        System.out.println(now()+this.getName()+"对象占有中");
                        Thread.sleep(5000);
                        System.out.println(now()+this.getName()+"对象释放");
                    }
                    System.out.println(now()+this.getName()+"线程结束");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.setName("thread1");
        thread.start();


        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(now()+this.getName()+"准备占有");
                    synchronized (someObject){
                        System.out.println(now()+this.getName()+"对象占有中");
                        Thread.sleep(5000);
                        System.out.println(now()+this.getName()+"对象释放");
                    }
                    System.out.println(now()+this.getName()+"线程结束");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread2.setName("thread2");
        thread2.start();


    }

    private static String now() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
}
