package com.anaa.xc;

/**
 * Created by dell on 2020/2/2.
 */
public class Battle implements Runnable {

    private Hero hero1;
    private Hero hero2;


    public Battle(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    @Override
    public void run() {

        while (!hero2.isDead()){
            hero1.attackHero(hero1);
        }
    }
}
