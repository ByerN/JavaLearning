package org.byern.javalearning.lesson9.homework.Homework2_Asia;


import org.byern.javalearning.lesson9.homework.Homework2_Asia.Beats.Beats;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Beats.Dog;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Beats.Sheep;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Beats.Wolf;
import org.byern.javalearning.lesson9.homework.Homework2_Asia.Human.*;


public class World {

    public static void main(String[] args) {

        greeting();

        Human[] humansList = {new Priest(), new Knight(), new Wizard()};
        Beats[] beatsList = {new Dog(), new Sheep(), new Wolf()};
        Player players = new Priest();

        Priest priest = new Priest();
        Wizard wizard = new Wizard();
        Knight knight = new Knight();

        Dog dog = new Dog();
        Wolf wolf = new Wolf();
        Sheep sheep = new Sheep();

//        parameter and backpack

        for(Beats beats : beatsList){
            beats.getStrength();
            beats.getHealthPoint();
        }

        for(Human human : humansList){
            human.getStrength();
            human.getHealthPoint();
            human.backpack();
        }


// fight
          for (Human human : humansList){
            human.attack(wizard);
        }

        for(Human human : humansList){
            human.fightWith(dog);}

        for(Beats beats : beatsList){
            beats.fightWith(priest);}

        priest.healHuman(knight);
        dog.fightWith(knight);
        priest.fightWith(sheep);
        knight.fightWith(wolf);

//        players
        players.attack(knight);

    }


    public static void greeting() {
        Human human1 = new Priest();
        Human human2 = new Wizard();
        Human human3 = new Knight();

        Beats beats1 = new Sheep();
        Beats beats2 = new Wolf();
        Beats beats3 = new Dog();

        System.out.println("There is a WORLD. Here are humans: ");
        human1.sayHello();
        human2.sayHello();
        human3.sayHello();

        System.out.println("\n.. and beats: ");
        beats1.sayHello();
        beats2.sayHello();
        beats3.sayHello();
    }


}
