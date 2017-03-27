package org.byern.javalearning.lesson8.abstractclassexample;

/**
 * Created by ByerN on 27.03.2017.
 */
public abstract class Pet extends SoundMaker{

    protected int pawNumber;

    public Pet() {
        this.pawNumber = 4;
    }

    protected Pet(int pawNumber) {
        this.pawNumber = pawNumber;
    }

    public abstract void doPet();

}
