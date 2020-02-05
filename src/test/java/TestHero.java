import java.util.*;
import java.util.stream.Stream;

/**
 * Created by dell on 2020/2/2.
 */
public class TestHero {


    public static void main(String[] args) {


        Random random = new Random();

        List<Hero> heros = new LinkedList<Hero>();

        for (int i = 0; i < 100; i++) {
            heros.add(new Hero("hero" + i, random.nextFloat()*1000, random.nextInt(100)));
        }


        System.err.println("111");
        //流编程很强
        heros.stream().filter(hero -> hero.hp>100&&hero.damage<50).forEach(hero -> System.out.println(hero.name));
        System.err.println("111");

        List arr = new ArrayList();

        arr.add("1");
        arr.add("2");
        arr.add("3");
        Stream.of(arr).filter(a->"3".equals(a)).forEach(a-> System.out.println(a));


//        Arrays.stream(ho).filter(hero -> hero.hp>100&&hero.damage<50).forEach(hero -> System.err.println(hero.name));
//
//管道源是数组
        Hero[] ho = (Hero[]) heros.toArray(); //ClassCastException 类型转换异常
        Hero hs[] = heros.toArray(new Hero[heros.size()]); //这样处理
        Arrays.stream(hs)
                .forEach(h->System.err.println(h.name));



        //bj(heros);



        HeroTwo heroTwo = new HeroTwo() {
            public boolean test(Hero hero) {
                return (hero.hp>100&&hero.damage<50);
            }
        };

        //引用静态内部类
        bjTwo(heros,TestHero::testHero);

        //bjTwo(heros,heroTwo);

        //lamed 表达式简写
        bjTwo(heros,h->h.hp>100&&h.damage<50);

        //引用对象的方法
        TestHero testHero = new TestHero();
        bjTwo(heros,testHero::testHero2);



    }
    public static boolean testHero(Hero h) {
        return h.hp>100 && h.damage<50;
    }

    public  boolean testHero2(Hero h) {
        return h.hp>100 && h.damage<50;
    }

    private static void bjTwo(List<Hero> heros, HeroTwo heroTwo) {

        for (Hero h : heros) {

            if (heroTwo.test(h))
                System.out.println(h);
        }
    }

    private static void bj(List<Hero> heros) {

        for (Hero hero : heros) {

            if (hero.hp>100&&hero.damage<50){
                System.out.println(hero);
            }
        }

    }


}
