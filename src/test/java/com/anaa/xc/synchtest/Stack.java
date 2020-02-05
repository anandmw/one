//
//package com.anaa.xc.synchtest;
//import java.util.LinkedList; 
//        import java.lang.reflect.Constructor;
//        import java.nio.charset.Charset;
//        import java.util.Collections;
//        import java.util.LinkedList;
//        import java.util.List;
//        import java.util.Random;
//         
//class stack<T>
//{
//    List<T> p;
//    public stack()
//    {
//        List<T> r=new LinkedList<>();
//        p= Collections.synchronizedList(r);
//    }
//    public synchronized void push(T k) throws InterruptedException {
//        while (p.size()==200)this.wait();
//        p.add(k);
//    }
//    public synchronized T pull()
//    {
//        if (p.size()<=1)this.notify();
//        return p.remove(p.size()-1);
//    }
//}
//class Producer implements Runnable
//{
//    stack<Character> p;
//    public Producer(stack<Character> p)
//    {
//        this.p=p;
//    }
//    @Override
//    public void run() {
//        Random e=new Random();
//        char h;
//        while (true)
//    {
//            h = (char) (e.nextInt(26)+'A');
// 
//        try {
//            System.out.println(Thread.currentThread().getName()+"  压入："+h);
//            p.push(h);
//            Thread.sleep(10);
//        } catch (InterruptedException e1) {
//            e1.printStackTrace();
//        }
//    }
//    }
//}
//class Consumer implements Runnable
//{
//    stack<Character> p;
//    public Consumer(stack<Character> p)
//    {
//        this.p=p;
//    }
//    @Override
//    public void run() {
//      while (true)
//      {
//          System.out.println(Thread.currentThread().getName()+"  弹出："+p.pull());
//          try {
//              Thread.sleep(100);
//          } catch (InterruptedException e) {
//              e.printStackTrace();
//          }
//      }
//    }
//}
//public class TEST {
//    public static void main(String[] args) throws InterruptedException {
//    stack<Character> t=new stack<>();
//        for(int i=0;i<2;i++)
//        {
//            new Thread(new Producer(t),"Producer"+(i+1)).start();
//        }
//        Thread.sleep(200);
//        for(int i=0;i<3;i++)
//        {
//            new Thread(new Consumer(t),"Consumer"+(i+1)).start();
//        }
//    }
//}