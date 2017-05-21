package org.byern.javalearning.lesson9.homework;

/**
 * Created by Vic on 2017-05-20.
 */
public class Sheep implements Beast {

    boolean runAway = false;

    @Override
    public boolean isAttack() {
        isRunAway();
        return false;
    }

    private void isRunAway() {
        runAway = true;
    }


}
