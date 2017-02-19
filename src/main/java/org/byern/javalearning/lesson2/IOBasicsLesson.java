package org.byern.javalearning.lesson2;

import java.util.Scanner;

/**
 * Created by ByerN on 19.02.2017.
 */
public class IOBasicsLesson {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); //Creates input to our program

        System.out.println("What is your name?"); //Outputs "What is your name?" to console

        //Reads input from console (finished with new line -> enter) and stores result in variable
        String name = scanner.next();

        //Outputs result from stored input
        System.out.println("Hello " + name);

        //Waits for input and outputs it with "Please enter how old are you: " string.
        System.out.println("Please enter how old are you: " + scanner.nextInt());
    }
}
