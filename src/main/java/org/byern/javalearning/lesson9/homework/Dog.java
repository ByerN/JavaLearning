package org.byern.javalearning.lesson9.homework;

/**
 * Created by Vic on 2017-05-20.
 */
public class Dog implements Beast {


    @Override
    public boolean isAttack() {
        if (Human.backpackElements.values().equals(Human.backpackElements.BONE)) return false;
        else
            return true;

    }
}
