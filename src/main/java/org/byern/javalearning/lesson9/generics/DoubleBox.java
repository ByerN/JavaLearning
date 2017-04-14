package org.byern.javalearning.lesson9.generics;

/**
 * Created by ByerN on 02.04.2017.
 */

/*
 * In this example, DoubleBox is an NumberBox of Double parametrized type
 */
public class DoubleBox extends NumberBox<Double> {


    public DoubleBox(Double item) {
        super(item);
    }
}
