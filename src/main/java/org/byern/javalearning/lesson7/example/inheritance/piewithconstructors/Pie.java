package org.byern.javalearning.lesson7.example.inheritance.piewithconstructors;

/**
 * Created by ByerN on 26.03.2017.
 */
class Pie {

    int water;
    int flour;

    /*
     * After adding a constructor to the class,
     * default one "disappears".
     *
     * Constructor below makes programmer to
     * explicitly tell what are "water" and "flour" values.
     */
    Pie(int water, int flour) {
        this.water = water;
        this.flour = flour;

        System.out.println("public Pie(int water, int flour) invoked");
    }
}
