package org.byern.javalearning.lesson8.abstractclassexample;

/**
 * Created by ByerN on 27.03.2017.
 */
public class Human {

    public void checkAnimalOverloaded(Dog dog) {
        System.out.println("Dog " + dog.getClass().getName());
    }

    public void checkAnimalOverloaded(Cat cat) {
        System.out.println("Cat " + cat.getClass().getName());
    }

    public void checkAnimalOverloaded(Snake snake) {
        System.out.println("Snake " + snake.getClass().getName());
    }

    public void petAnimal(Pet pet) {
        System.out.println("Pet: " + pet.getClass().getName());
        pet.doPet();
    }

    public void talkTo(SoundMaker soundMaker) {
        /*
         * Usage of instance should be limited.
         * Instead try to use more polymorphic constructions.
         */
        if (soundMaker instanceof Dog) {
            System.out.println("Hi doggy!!!");
        } else if (soundMaker instanceof Cat) {
            System.out.println("Hi kitty!!!");
        } else if (soundMaker instanceof Snake) {
            System.out.println("Hi snaky!!!");
        }
        soundMaker.makeSound();
    }
}
