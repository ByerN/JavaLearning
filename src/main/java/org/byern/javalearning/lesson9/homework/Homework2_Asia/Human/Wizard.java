package org.byern.javalearning.lesson9.homework.Homework2_Asia.Human;

import org.byern.javalearning.lesson9.homework.Homework2_Asia.Beats.Dog;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Beats.Sheep;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Beats.Wolf;

import java.util.ArrayList;
import java.util.List;

public class Wizard implements Human {

    protected int strength = 10;
    protected int healthPoint = 10;
    protected String myName = "WIZARD";

    @Override
    public void sayHello() {
        System.out.println("Hi, I'm Wizard");
    }

    @Override
    public void getStrength() {
        System.out.println("\nStrength of wizard is: " + getWizardStrength());
    }

    @Override
    public void getHealthPoint() {
        System.out.println("HP of wizard is: " + getWizardHealthPoint());
    }

    public void fightWith(Dog dog) {
        System.out.println("Wizard is fighting with dog");
        castSpells();
    }

    @Override
    public void fightWith(Sheep sheep) {
        System.out.println("Wizard is fighting with sheep");
        castSpells();
        sheep.runAway();
    }

    @Override
    public void fightWith(Wolf wolf) {
        System.out.println("Wizard is fighting with wolf");
        castSpells();
    }


    @Override
    public void attack(Wizard wizard) {
        System.out.println("Wizard attacks wizard. You are a PLAYER KILLER!");
        castSpells();
    }

    @Override
    public void attack(Knight knight) {
        System.out.println("Wizard attacks knight. You are a PLAYER KILLER!");
        castSpells();
    }

    @Override
    public void attack(Priest priest) {
        System.out.println("Wizard attacks priest. You are a PLAYER KILLER!");
        castSpells();
    }


    protected int getWizardStrength() {
        return strength;
    }

    protected int getWizardHealthPoint() {
        return healthPoint;
    }

    @Override
    public List<String> backpack() {
        Item items = new Item();
        List<String> listItems = new ArrayList<>();
        listItems.add(items.getBoots());
        listItems.add(items.getCloth());

        for (String itemsList : listItems) {
            System.out.println("Wizard has in the backpack: " + itemsList);
        }

        return listItems;
    }

    @Override
    public String getMyName() {
        return myName;
    }

    public void castSpells() {
        System.out.println("I'm casting a spells!: tiruriru");
    }
}
