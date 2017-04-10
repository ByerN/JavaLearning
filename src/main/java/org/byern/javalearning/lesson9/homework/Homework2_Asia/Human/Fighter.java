package org.byern.javalearning.lesson9.homework.Homework2_Asia.Human;

import org.byern.javalearning.lesson9.homework.Homework2_Asia.Beats.Dog;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Beats.Sheep;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Beats.Wolf;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Player;

public interface Fighter extends Player {

    void fightWith(Dog dog);
    void fightWith(Sheep sheep);
    void fightWith(Wolf wolf);

}
