package org.byern.javalearning.lesson7.example.inheritance.piewithconstructors;

/**
 * Created by ByerN on 26.03.2017.
 */
public class PieMain {

    public static void main(String[] args) {
        //Pie basicPie = new Pie(); // cannot be used -> there is no non-arg constructor for Pie class
        //Take a look at constructor invocation order when creating objects
        Pie basicPie = new Pie(1, 2);
        //public Pie(int water, int flour) invoked

        System.out.println("basicPie before update");
        System.out.println("basicPie.flour=" + basicPie.flour);
        System.out.println("basicPie.water=" + basicPie.water);
        basicPie.flour = 5;
        basicPie.water = 3;
        System.out.println("basicPie after update");
        System.out.println("basicPie.flour=" + basicPie.flour);
        System.out.println("basicPie.water=" + basicPie.water);

        ApplePie applePie = new ApplePie(1, 2, 3);
        /*
        public Pie(int water, int flour) invoked
        public ApplePie(int water, int flour) invoked
        public ApplePie(int water, int flour, int apple) invoked
         */
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

        BananaPie bananaPie = new BananaPie(1, 2, 3);
        /*
        public Pie(int water, int flour) invoked
        public BananaPie(int water, int flour) invoked
        public BananaPie(int water, int flour, int banana) invoked
         */
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
