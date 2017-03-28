package org.byern.javalearning.lesson8.abstractclassexample;

/**
 * Created by ByerN on 27.03.2017.
 */
public class Dog extends Pet {

    protected Dog() {
        super(3); //All dogs will have 3 legs. Why? Idk.
    }

    /*
         *  Every method from abstract class has to be implemented in implementing class.
         *  It means that it should have body and same signature as abstract method.
         */
    @Override//@Override annotation is optional but leaving it here is a good practice
    public void makeSound() {
        System.out.println("Hau!");
    }

    @Override
    public void move() {
        System.out.println("Moving on " + pawNumber + " paws!");
    }

    @Override
    public void doPet() {
        System.out.println("Pet the dog!");
    }
}
