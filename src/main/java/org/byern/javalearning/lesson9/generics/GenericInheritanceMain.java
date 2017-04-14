package org.byern.javalearning.lesson9.generics;

/**
 * Created by ByerN on 02.04.2017.
 */
public class GenericInheritanceMain {

    public static void main(String[] args) {
        IntegerBox integerBox = new IntegerBox(1);
        DoubleBox doubleBox = new DoubleBox(2.0);

        NumberBox<Number> numberBox;
        //numberBox = integerBox; //Not working
        //numberBox = doubleBox; //Not working

        NumberBox<Integer> numberBoxInteger;
        numberBoxInteger = integerBox; //Works
        //numberBoxInteger = doubleBox; //Not working
    }
}
