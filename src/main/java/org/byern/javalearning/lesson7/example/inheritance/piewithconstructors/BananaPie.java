package org.byern.javalearning.lesson7.example.inheritance.piewithconstructors;

/**
 * Created by ByerN on 26.03.2017.
 */
class BananaPie extends Pie {

    int banana;

    BananaPie(int water, int flour) {
        super(water, flour);
        System.out.println("public BananaPie(int water, int flour) invoked");
        //do something more
    }

    BananaPie(int water, int flour, int banana) {
        this(water, flour); //this constructor used instead of super
        this.banana = banana;
        System.out.println("public BananaPie(int water, int flour, int banana) invoked");
        //do something more
    }
}
