package org.byern.javalearning.lesson9.homework.Homework2_Asia.Human;

import org.byern.javalearning.lesson9.homework.Homework2_Asia.Beats.Dog;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Beats.Sheep;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Beats.Wolf;

import java.util.ArrayList;
import java.util.List;

public class Priest implements Human {

    protected int strength = 2;
    protected int healthPoint = 7;
    protected String myName = "PRIEST";

    @Override
    public void sayHello() {
        System.out.println("Hi, I'm Priest");
    }

    @Override
    public void getStrength() {
        System.out.println("\nStrength of priest is: " + getPriestStrength());
    }

    @Override
    public void getHealthPoint() {
        System.out.println("HP of priest is: " + getPriestHealthPoint());
    }

    @Override
    public void fightWith(Dog dog) {
        System.out.println("Priest is fighting with dog");
    }

    @Override
    public void fightWith(Sheep sheep) {
        System.out.println("Priest is fighting with sheep");
        sheep.runAway();
    }

    @Override
    public void fightWith(Wolf wolf) {
        System.out.println("Priest is fighting with wolf");
    }

    @Override
    public void attack(Wizard wizard) {
        System.out.println("Priest attacks wizard. You are a PLAYER KILLER!");
    }

    @Override
    public void attack(Knight knight) {
        System.out.println("Priest attacks knight. You are a PLAYER KILLER!");
    }

    @Override
    public void attack(Priest priest) {
        System.out.println("Priest attacks priest. You are a PLAYER KILLER!");
    }

    protected int getPriestStrength() {
        return strength;
    }

    protected int getPriestHealthPoint() {
        return healthPoint;
    }

    @Override
    public List<String> backpack() {
        Item items = new Item();
        List<String> listItems = new ArrayList<>();
        listItems.add(items.getLipstick());
        listItems.add(items.getFork());

        for (String itemsList : listItems) {
            System.out.println("Priest has in the backpack: " + itemsList);
        }

        return listItems;
    }

    @Override
    public String getMyName() {
        return myName;
    }

    public void healHuman(Human human) {
        System.out.println("I can heal: " + human.getMyName());
    }
}
