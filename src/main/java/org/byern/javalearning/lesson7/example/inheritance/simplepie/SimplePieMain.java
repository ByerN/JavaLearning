package org.byern.javalearning.lesson7.example.inheritance.simplepie;

/**
 * Created by ByerN on 26.03.2017.
 */
public class SimplePieMain {

    public static void main(String[] args) {
        Pie basicPie = new Pie();
        System.out.println("basicPie before update");
        System.out.println("basicPie.flour=" + basicPie.flour);
        System.out.println("basicPie.water=" + basicPie.water);
        basicPie.flour = 5;
        basicPie.water = 3;
        System.out.println("basicPie after update");
        System.out.println("basicPie.flour=" + basicPie.flour);
        System.out.println("basicPie.water=" + basicPie.water);

        ApplePie applePie = new ApplePie();
        System.out.println("applePie before update");
        System.out.println("applePie.flour=" + applePie.flour);
        System.out.println("applePie.water=" + applePie.water);
        System.out.println("applePie.apple=" + applePie.apple);
        applePie.flour = 5;
        applePie.water = 3;
        applePie.apple = 4;
        System.out.println("applePie after update");
        System.out.println("applePie.flour=" + applePie.flour);
        System.out.println("applePie.water=" + applePie.water);
        System.out.println("applePie.apple=" + applePie.apple);

        BananaPie bananaPie = new BananaPie();
        System.out.println("bananaPie before update");
        System.out.println("bananaPie.flour=" + bananaPie.flour);
        System.out.println("bananaPie.water=" + bananaPie.water);
        System.out.println("bananaPie.banana=" + bananaPie.banana);
        bananaPie.flour = 5;
        bananaPie.water = 3;
        bananaPie.banana = 4;
        System.out.println("bananaPie after update");
        System.out.println("bananaPie.flour=" + bananaPie.flour);
        System.out.println("bananaPie.water=" + bananaPie.water);
        System.out.println("bananaPie.banana=" + bananaPie.banana);

    }
}
