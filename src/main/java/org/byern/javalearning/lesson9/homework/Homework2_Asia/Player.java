package org.byern.javalearning.lesson9.homework.Homework2_Asia;


import org.byern.javalearning.lesson9.homework.Homework2_Asia.Human.Knight;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Human.Priest;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Human.Wizard;

public interface Player extends Parameters{

    void attack(Wizard wizard);
    void attack(Knight knight);
    void attack(Priest priest);
}
