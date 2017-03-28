package org.byern.javalearning.lesson8;

/**
 * Created by ByerN on 26.03.2017.
 */
/*
 * For interface declaration "class" keyword should be replaced with "interface" keyword
 */
public interface InterfaceExample {

    //public static final String SOME_CONSTANT; //compilation error. Default final
    public static final String SOME_CONSTANT_1 = "someValue"; //public static final keywords are redundant
    String SOME_CONSTANT_2 = "someValue";//use something like this instead


    public abstract void abstractMethod1(); //public and abstract keywords are redundant.
    void abstractMethod2(); //use something like this instead.
}
