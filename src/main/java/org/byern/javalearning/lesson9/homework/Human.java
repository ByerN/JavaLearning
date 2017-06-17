package org.byern.javalearning.lesson9.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vic on 2017-05-21.
 */


public abstract class Human implements Life {

    public enum backpackElements {BONE, MAP}

    private List backpack = new ArrayList<backpackElements>();

    Human() {
        this.backpack = backpack;
    }

    void fightBeast() {
    }
}