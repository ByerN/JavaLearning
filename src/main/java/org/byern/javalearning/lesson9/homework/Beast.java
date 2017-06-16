package org.byern.javalearning.lesson9.homework;

/**
 * Created by Vic on 2017-05-20.
 */
public interface Beast extends Life {
    boolean canFightHuman = true;
    boolean canAttackOtherBeast = false;


    boolean isAttack();
}
