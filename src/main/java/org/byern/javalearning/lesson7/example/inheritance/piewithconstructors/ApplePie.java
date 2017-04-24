package org.byern.javalearning.lesson7.example.inheritance.piewithconstructors;

/**
 * Created by ByerN on 26.03.2017.
 */
class ApplePie extends Pie {

    int apple;

    /*
     * If super class doesn't provide non argument constructor,
     * superclass constructor has to be called explicitly.
     *
     * Without constructor below (or second one in this file), it's compilation error.
     * There is no non-argument superclass constructor to invoke
     * not explicitly.
     */
    ApplePie(int water, int flour) {
        super(water, flour);//every constructor has to invoke superclass constructor in it's body
        //if there is no "super" in constructor's body default one is invoked (if exists).

        System.out.println("public ApplePie(int water, int flour) invoked");
    }

    ApplePie(int water, int flour, int apple) {
        this(water, flour);
        this.apple = apple;

        System.out.println("public ApplePie(int water, int flour, int apple) invoked");
    }
}
