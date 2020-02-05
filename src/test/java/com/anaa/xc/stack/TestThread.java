package com.anaa.xc.stack;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2020/2/4.
 */
public class TestThread {

    public static void main(String[] args) {

        Mystack<Character> stack = new Mystack<>();

        new ProducerThred(stack,"prodicer1").start();
        new ProducerThred(stack,"prodicer2").start();
        new ConsumerThread(stack,"Consumer1").start();
        new ConsumerThread(stack,"Consumer2").start();
        new ConsumerThread(stack,"Consumer3").start();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(20, 60, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());


    }
}
