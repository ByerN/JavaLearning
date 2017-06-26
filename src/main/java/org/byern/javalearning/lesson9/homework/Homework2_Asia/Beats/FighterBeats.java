package org.byern.javalearning.lesson9.homework.Homework2_Asia.Beats;


import org.byern.javalearning.lesson9.homework.Homework2_Asia.Human.Knight;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Human.Priest;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Human.Wizard;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Parameters;

public interface FighterBeats extends Parameters {

    void fightWith(Wizard wizard);
    void fightWith(Knight knight);
    void fightWith(Priest priest);
}
