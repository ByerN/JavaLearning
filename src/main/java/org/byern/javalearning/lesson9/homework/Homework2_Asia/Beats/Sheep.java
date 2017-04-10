package org.byern.javalearning.lesson9.homework.Homework2_Asia.Beats;


import org.byern.javalearning.lesson9.homework.Homework2_Asia.Human.Human;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Human.Knight;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Human.Priest;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Human.Wizard;

public class Sheep implements Beats{

    protected int strength = 3;
    protected int healthPoint = 9;

    @Override
    public void sayHello() {
        System.out.println("Hi, I'm Sheep");
    }

    @Override
    public void getStrength() {System.out.println("\nStrength of sheep is: " + getSheepStrength());}

    @Override
    public void getHealthPoint() {System.out.println("HP of sheep is: " + getSheepHealthPoint());}

    @Override
    public void fightWith(Wizard wizard) {System.out.println("Sheep is fighting with wizard");}

    @Override
    public void fightWith(Knight knight) {System.out.println("Sheep is fighting with knight");}

    @Override
    public void fightWith(Priest priest) {System.out.println("Sheep is fighting with priest");}

    protected int getSheepStrength() {return strength;}
    protected int getSheepHealthPoint() {return healthPoint;}

    public void runAway(){
        System.out.println("Sheep is running away!");
    };

}
