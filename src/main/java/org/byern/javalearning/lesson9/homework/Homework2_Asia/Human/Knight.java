package org.byern.javalearning.lesson9.homework.Homework2_Asia.Human;


import org.byern.javalearning.lesson9.homework.Homework2_Asia.Beats.Dog;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Beats.Sheep;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Beats.Wolf;

import java.util.ArrayList;
import java.util.List;

public class Knight implements Human {

    protected int strength = 7;
    protected int healthPoint = 7;
    protected String myName = "KNIGHT";

    @Override
    public void sayHello() {
        System.out.println("Hi, I'm Knight");
    }

    @Override
    public void getStrength() {
        System.out.println("\nStrength of knight is: " + getKnightStrength());
    }

    @Override
    public void getHealthPoint() {
        System.out.println("HP of knight is: " + getKnightHealthPoint());
    }

    @Override
    public void fightWith(Dog dog) {
        System.out.println("Knight is fighting with dog");
    }

    @Override
    public void fightWith(Sheep sheep) {
        System.out.println("Knight is fighting with sheep");
        sheep.runAway();
    }

    @Override
    public void fightWith(Wolf wolf) {
        System.out.println("Knight is fighting with wolf");
    }


    @Override
    public void attack(Wizard wizard) {
        System.out.println("Knight attack wizard");
    }

    @Override
    public void attack(Knight knight) {
        System.out.println("Knight attacks knight");
    }

    @Override
    public void attack(Priest priest) {
        System.out.println("Knight attacks priest");
    }

    protected int getKnightStrength() {
        return strength;
    }

    protected int getKnightHealthPoint() {
        return healthPoint;
    }

    @Override
    public List<String> backpack() {
        Item items = new Item();
        List<String> listItems = new ArrayList<>();
        listItems.add(items.getBone());
        listItems.add(items.getKnife());
        listItems.add(items.getLipstick());

        for (String itemsList : listItems) {
            System.out.println("Knight has in the backpack: " + itemsList);
        }

        return listItems;
    }

    @Override
    public String getMyName() {
        return myName;
    }

    public void strong() {
    }
}
