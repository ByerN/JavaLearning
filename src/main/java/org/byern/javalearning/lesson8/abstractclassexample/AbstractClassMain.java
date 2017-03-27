package org.byern.javalearning.lesson8.abstractclassexample;

/**
 * Created by ByerN on 27.03.2017.
 */
public class AbstractClassMain {

    public static void main(String[] args) {
        System.out.println("Cat:");
        Cat cat = new Cat();
        cat.makeSound();
        cat.move();
        cat.doPet();

        System.out.println();
        System.out.println("Dog:");
        Dog dog = new Dog();
        dog.makeSound();
        dog.move();
        dog.doPet();

        System.out.println();
        System.out.println("Snake:");
        Snake snake = new Snake();
        snake.makeSound();
        snake.move();
        snake.doReptileThings();

        System.out.println();

        SoundMaker[] soundMakers = {
                new Cat(),
                new Dog(),
                new Snake()
        };
        for (SoundMaker soundMaker : soundMakers) {
            soundMaker.makeSound();
        }


        Movable[] movables = {
                new Cat(),
                new Dog(),
                new Snake()
        };
        for (Movable movable : movables) {
            movable.move();
        }

        Pet[] pets = {
                new Cat(),
                new Dog(),
                //new Snake() // snake cannot be here. It's not a doPet
        };
        for (Pet pet : pets) {
            pet.makeSound();
            pet.doPet();
        }

        Reptile[] reptiles = {
                //new Cat(),//cannot be here -> not a reptile
                //new Dog(),//cannot be here -> not a reptile
                new Snake()
        };
        for (Reptile reptile : reptiles) {
            reptile.doReptileThings();
            reptile.makeSound();
            reptile.move();
        }

        Human human = new Human();

        for (Pet pet : pets) {
            human.petAnimal(pet);
        }

        for (SoundMaker soundMaker : soundMakers) {
            human.talkTo(soundMaker);
        }

        //human.checkAnimalOverloaded(soundMakers); //cannot be resolved there is no method of SoundMaker type

        SoundMaker catToCheckOverloading = new Cat();
        SoundMaker dogToCheckOverloading = new Dog();
        SoundMaker snakeToCheckOverloading = new Snake();

        //human.checkAnimalOverloaded((Dog) catToCheckOverloading); //class cast exception
        //java.lang.ClassCastException: Cat cannot be cast to Dog
        human.checkAnimalOverloaded((Cat) catToCheckOverloading);
        human.checkAnimalOverloaded((Snake) snakeToCheckOverloading);
        human.checkAnimalOverloaded((Dog) dogToCheckOverloading);

    }
}
