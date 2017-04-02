package org.byern.javalearning.lesson9.generics;

/**
 * Created by ByerN on 02.04.2017.
 */
public class WildCardPacker {

    /*
     * Wildcards are used to define "any" type.
     * "?" -> wildcard
     *
     * https://docs.oracle.com/javase/tutorial/java/generics/wildcards.html
     */
    public static Object unpack(Box<?> box){//unbounded wildcard -> anything
        return box.getItem();
    }

    /*
     public static Object unpack(Box<? extends Number> box){//compilation error-> duplicated method signature
        return box.getItem();
    }
     */

    public static Number unpackNumber(Box<? extends Number> box){//Upper bounded wildcard -> anything extending Number
        return box.getItem();
    }

    public static Object unpackInteger(Box<? super Integer> box){//Lower bounded wildcard -> anything that can hold Integer
        return box.getItem();
    }

    public static void main(String[] args) {
        IntegerBox integerBox = new IntegerBox(1);
        DoubleBox doubleBox = new DoubleBox(2.0);

        NumberBox<? extends Number> numberBox;
        numberBox = integerBox; //Works
        numberBox = doubleBox; //Works

        NumberBox<? super Integer> numberBoxInteger;
        numberBoxInteger = integerBox; //Works
        //numberBoxInteger = doubleBox; //Not working
    }
}
