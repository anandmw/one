package com.anaa.xc;

import org.junit.Test;

/**
 * Created by dell on 2020/2/2.
 */
public class TestThread {


    @Test
    public void test1(){
        System.out.println("23");
    }

    public static void main(String[] args) {

        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        /*new KillThread(gareen,teemo).start();
        new KillThread(bh,leesin).start();*/

//        Battle battle1 = new Battle(gareen,teemo);
//        new Thread(battle1).start();
//
//        Battle battle2 = new Battle(bh,leesin);
//        new Thread(battle2).start();


        //匿名内部类的好处是可以直接在run方法中写业务代码
        //匿名类的一个好处是可以很方便的访问外部的局部变量。
        Thread thread = new Thread(){
            @Override
            public void run() {

                while (!teemo.isDead()){
                    gareen.attackHero(teemo);
                }
            }
        };
        thread.start();

        Thread thread1 = new Thread(){

            @Override
            public void run() {

                while(!leesin.isDead()){
                    bh.attackHero(leesin);
                }
            }
        };
        thread1.start();


    }
}
