package org.byern.javalearning.lesson9.homework.Homework1_Asia;


import java.util.Scanner;

public class Case3ReadFromConsole implements HelloWorldService {

    private String greeting;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void greetWorld() {
        provideGreeting();
    }

    public void provideGreeting() {

        System.out.println("Provide a greeting with the world: ");
        greeting = scanner.nextLine();

        while (!(greeting.equals("Hello World"))) {
            System.out.println("Please provide correct greeting!");
            greeting = scanner.nextLine();
        }
    }
}
