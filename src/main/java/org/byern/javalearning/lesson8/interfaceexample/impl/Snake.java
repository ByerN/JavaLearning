package org.byern.javalearning.lesson8.interfaceexample.impl;

import org.byern.javalearning.lesson8.interfaceexample.Movable;
import org.byern.javalearning.lesson8.interfaceexample.Reptile;
import org.byern.javalearning.lesson8.interfaceexample.SoundMaker;

/**
 * Created by ByerN on 27.03.2017.
 */
public class Snake implements SoundMaker, Movable, Reptile {
    //SoundMaker, Movable, are redundant. Can be removed (Reptile extends it)

    /*
     *  Every method from interface has to be implemented in implementing class.
     *  It means that it should have body and same signature as interface method.
     */
    @Override//@Override annotation is optional but leaving it here is a good practice
    public void makeSound() {
        System.out.println("Sssssss...");
    }

    @Override
    public void move() {
        System.out.println("Sliding...");
    }

    @Override
    public void doReptileThings() {
        System.out.println("Doing reptile things...");
    }
}
