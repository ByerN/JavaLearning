package org.byern.javalearning.lesson9;

/**
 * Created by krzyspo on 04/04/2017.
 */
public class Example1Main {

    interface Animal {
        void feed();
        void feed(Feeder feeder);
    }

    interface Feeder {
        void feedAnimal(Cat cat);
        void feedAnimal(Dog dog);
        void feedAnimal(Snake snake);
        void feedAnimal(Horse horse);
    }

    public static class Horse implements Animal {
        @Override
        public void feed() {
            System.out.println("Fed cat");
        }

        @Override
        public void feed(Feeder feeder) {
            feeder.feedAnimal(this);
        }
    }

    public static class Cat implements Animal {
        @Override
        public void feed() {
            System.out.println("Fed cat");
        }

        @Override
        public void feed(Feeder feeder) {
            feeder.feedAnimal(this);
        }
    }
    public static class Snake implements Animal {
        @Override
        public void feed() {
            System.out.println("Fed snake");
        }

        @Override
        public void feed(Feeder feeder) {
            feeder.feedAnimal(this);
        }
    }

    public static class Dog implements Animal {
        @Override
        public void feed() {
            System.out.println("Fed dog");
        }

        @Override
        public void feed(Feeder feeder) {
            feeder.feedAnimal(this);
        }
    }

    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Cat(), new Snake(), new Horse()};
        Human human = new Human();
        for (Animal animal : animals){
            animal.feed();
        }

        for (Animal animal : animals){
           // human.feedAnimal(animal);
        }

        for (Animal animal : animals){
            animal.feed(human);
        }

        BadHuman badHuman = new BadHuman();

        for (Animal animal : animals){
            animal.feed(badHuman);
        }

    }


    public static class Human implements Feeder{

        public void feedAnimal(Cat cat){
            System.out.println("Fed cat with meat");
        }

        public void feedAnimal(Dog dog){
            System.out.println("Fed dog with meat");
        }

        @Override
        public void feedAnimal(Snake snake) {
            System.out.println("Fed snake with meat");
        }

        @Override
        public void feedAnimal(Horse horse) {
            System.out.println("Fed horse with sugar");
        }

    }

    public static class BadHuman implements Feeder{

        public void feedAnimal(Cat cat){
            System.out.println("FU");
        }

        public void feedAnimal(Dog dog){
            System.out.println("FU");
        }

        @Override
        public void feedAnimal(Snake snake) {
            System.out.println("FU");
        }

        @Override
        public void feedAnimal(Horse horse) {
            System.out.println("FU");
        }

    }
}
