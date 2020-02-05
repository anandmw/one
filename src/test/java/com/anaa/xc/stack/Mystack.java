package com.anaa.xc.stack;

import java.util.LinkedList;

/**
 * Created by dell on 2020/2/4.
 */
public class Mystack<T> {

    LinkedList<T> values = new LinkedList<T>();

    public synchronized void push(T t) {

        while (values.size()>=200){

            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.notifyAll();
            values.addLast(t);
        }

    }

    public synchronized T pull() {

        while (values.isEmpty()){

            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        this.notifyAll();
        return values.removeLast();
    }

    public T peek(){
        return values.getLast();
    }
}
