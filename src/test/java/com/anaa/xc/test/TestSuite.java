package com.anaa.xc.test;

import com.anaa.xc.readFile.SearchThread;
import com.anaa.xc.synchtest.TestThread;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dell on 2020/2/4.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestThread.class, SearchThread.class})
public class TestSuite {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        Condition condition = lock.newCondition();
        Thread thread = new Thread() {

            @Override
            public void run() {

                boolean locked=false;
                try {
                    locked = lock.tryLock();
                    if (locked){

                        condition.await();//thisThread等待
                        condition.signal();//唤醒
                    }else
                        System.out.println("没有占到");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (locked)
                    lock.unlock();
                }
            }
        };

//        Thread thread = new Thread() {
//
//            @Override
//            public void run() {
//
//                try {
//                    lock.lock();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
//            }
//        };
    }




}
