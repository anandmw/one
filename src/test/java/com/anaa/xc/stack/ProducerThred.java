package com.anaa.xc.stack;

/**
 * Created by dell on 2020/2/4.
 */
public class ProducerThred  extends Thread{


    private Mystack<Character> stack;

    public ProducerThred(Mystack<Character> stack,String name) {
        super(name);
        this.stack = stack;
    }

    public void run(){
        while (true){
            char c = randomChar();
            stack.push(c);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public char randomChar(){
        return (char) (Math.random()*('Z'+1-'A')+'A');
    }

}
