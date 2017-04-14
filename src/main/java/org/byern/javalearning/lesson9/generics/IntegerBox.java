package org.byern.javalearning.lesson9.generics;

/**
 * Created by ByerN on 02.04.2017.
 */

/*
 * In this example, IntegerBox is an NumberBox of Integer parametrized type
 */
public class IntegerBox extends NumberBox<Integer> {


    public IntegerBox(Integer item) {
        super(item);
    }
}
