package org.byern.javalearning.lesson7.example.inheritance.objectextending;

/**
 * Created by ByerN on 26.03.2017.
 */
/*
 * This class is the explicit example of SomeClass.
 *
 * Every class extends Object class.
 * If there is no constructor provided in class definition, default one
 * is added.
 * super() is referring to default Object class non-explicit constructor.
 *
 * Looking at the decompiled SomeClass.class file, super() doesn't appear.
 * It's default java mechanics.
 *
 * There is no need to write it all explicitly.
 *
 */
class SomeClassExplicit extends Object {

    SomeClassExplicit() {
        //int a = 1;//adding this line will cause compilation error
        super();
        /*
         * super(); is a superclass constructor invocation
         * it has to be called at first line of constructor.
         * This one can be removed in this case.
         * check: org.byern.javalearning.lesson7.example.inheritance.piewithconstructors.ApplePie
         *
         * this(); is a "this" class constructor invocation.
         * it has to be called at first line of constructor.
         *
         */
    }
}
