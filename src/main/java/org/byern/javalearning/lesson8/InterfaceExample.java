package org.byern.javalearning.lesson8;

/**
 * Created by ByerN on 26.03.2017.
 */
/*
 * For interface declaration "class" keyword should be replaced with "interface" keyword
 * służy do wyznaczania wspólnych cech, pokazać co mozemy zrobic do grupie rzeczy
 *  w interfejsach nie mozemy implementowac zmiennych - dodawac cech - moga byc tylko stałe (public static final)
 *  każda metoda jest domyslna publczna i abstrakcyjna
 */
public interface InterfaceExample {

    //public static final String SOME_CONSTANT; //compilation error. Default final
    public static final String SOME_CONSTANT_1 = "someValue"; //public static final keywords are redundant
    String SOME_CONSTANT_2 = "someValue";//use something like this instead


    public abstract void abstractMethod1(); //public and abstract keywords are redundant.
    void abstractMethod2(); //use something like this instead.
}
