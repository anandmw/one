package com.anaa.xc;

/**
 * Created by dell on 2020/2/2.
 */
public class KillThread extends Thread{

    private Hero hero1;
    private Hero hero2;

    public KillThread(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    @Override
    public void run() {
        while (!hero2.isDead()){
            hero1.attackHero(hero2);
        }
    }
}
