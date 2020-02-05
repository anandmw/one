package com.anaa.xc.stack;

/**
 * Created by dell on 2020/2/4.
 */
public class ConsumerThread extends Thread{

    private Mystack<Character> stack;

    public ConsumerThread(Mystack<Character> stack, String name) {

        super(name);
        this.stack=stack;
    }


    @Override
    public void run() {
        while (true){
            char c = stack.pull();
            System.out.println(this.getName()+"弹出"+c);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
