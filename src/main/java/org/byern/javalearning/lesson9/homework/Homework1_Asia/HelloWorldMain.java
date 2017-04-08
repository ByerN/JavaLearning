package org.byern.javalearning.lesson9.homework.Homework1_Asia;


public class HelloWorldMain {

    public static void main(String[] args) {

        HelloWorldService[] helloWorldServices = {new Case1SimpleRead(), new Case2ReadFromFile(), new Case3ReadFromConsole()};
        for(HelloWorldService helloWorldService : helloWorldServices){
            helloWorldService.greetWorld();
        }
    }
}
