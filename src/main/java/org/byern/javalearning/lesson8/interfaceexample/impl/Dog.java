package org.byern.javalearning.lesson8.interfaceexample.impl;

import org.byern.javalearning.lesson8.interfaceexample.Movable;
import org.byern.javalearning.lesson8.interfaceexample.Pet;
import org.byern.javalearning.lesson8.interfaceexample.SoundMaker;

/**
 * Created by ByerN on 27.03.2017.
 */
public class Dog implements SoundMaker, Movable, Pet {

    /*
     *  Every method from interface has to be implemented in implementing class.
     *  It means that it should have body and same signature as interface method.
     */
    @Override//@Override annotation is optional but leaving it here is a good practice
    public void makeSound() {
        System.out.println("Hau!");
    }

    @Override
    public void move() {
        System.out.println("Moving on 4 paws!");
    }

    @Override
    public void doPet() {
        System.out.println("Pet the dog!");
    }
}
