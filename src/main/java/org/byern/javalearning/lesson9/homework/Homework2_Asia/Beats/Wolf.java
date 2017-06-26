package org.byern.javalearning.lesson9.homework.Homework2_Asia.Beats;


import org.byern.javalearning.lesson9.homework.Homework2_Asia.Human.Knight;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Human.Priest;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Human.Wizard;

public class Wolf implements Beats {

    protected int strength = 10;
    protected int healthPoint = 9;

    @Override
    public void sayHello() {
        System.out.println("Hi, I'm Wolf");
    }

    @Override
    public void getStrength() {
        System.out.println("\nStrength of wolf is: " + getWolfStrength());
    }

    @Override
    public void getHealthPoint() {
        System.out.println("HP of wolf is: " + getWolfHealthPoint());
    }

    @Override
    public void fightWith(Wizard wizard) {
        System.out.println("Wolf is fighting with wizard");
        bite();
    }

    @Override
    public void fightWith(Knight knight) {
        System.out.println("Wolf is fighting with knight");
        bite();
    }

    @Override
    public void fightWith(Priest priest) {
        System.out.println("Wolf is fighting with priest");
        bite();
    }

    protected int getWolfStrength() {
        return strength;
    }

    protected int getWolfHealthPoint() {
        return healthPoint;
    }

    public void bite() {
        System.out.println("Dog bites");
    }
}
