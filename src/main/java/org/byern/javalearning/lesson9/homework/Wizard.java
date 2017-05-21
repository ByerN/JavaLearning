package org.byern.javalearning.lesson9.homework;

/**
 * Created by Vic on 2017-05-20.
 */
public class Wizard extends Human {
    boolean castingSpellsWhenFighting = true;

    Wizard(){
        super();
        castingSpellsWhenFighting = true;


    }



    void fightBeast(){
        castSpell();
    }

    private void castSpell() {

    }
}
