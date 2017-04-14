package org.byern.javalearning.lesson9.homework.Homework2_Asia.Beats;

import org.byern.javalearning.lesson9.homework.Homework2_Asia.Human.Human;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Human.Knight;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Human.Priest;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Human.Wizard;

public class Dog implements Beats {

    protected int strength = 5;
    protected int healthPoint = 8;

    @Override
    public void sayHello() {
        System.out.println("Hi, I'm Dog");
    }

    @Override
    public void getStrength() {
        System.out.println("\nStrength of dog is: " + getDogStrength());
    }

    @Override
    public void getHealthPoint() {
        System.out.println("HP of dog is: " + getDogHealthPoint());
    }

    @Override
    public void fightWith(Wizard wizard) {
        fightIfYouCan(wizard);
    }

    @Override
    public void fightWith(Knight knight) {
        fightIfYouCan(knight);
    }

    @Override
    public void fightWith(Priest priest) {
        fightIfYouCan(priest);
    }

    protected int getDogStrength() {
        return strength;
    }

    protected int getDogHealthPoint() {
        return healthPoint;
    }

    public void bite() {
        System.out.println("Dog bites");
    }

    public void fightIfYouCan(Human human) {
        if (human.backpack().contains("Bone")) {
            System.out.println("Dog won't attack if Human has a bone in his backpack!");
        } else {
            bite();
        }
    }
}
