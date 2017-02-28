package org.byern.javalearning.lesson4.homework;

import java.util.Scanner;

/**
 * Created by ByerN on 26.02.2017.
 */
public class Homework2 {

    public static void main(String[] args) {
        /*
         * Create 2 methods for factorial calculation
         * 1. using recursion
         * 2. using loop
         *
         * calculateFactorialUsingRecursion(int n)
         * calculateFactorialUsingLoop(int n)
         *
         * n -> indicates which number to calculate
         *
         * -non-positive numbers can be treated like 0
         */

        Scanner scanner = new Scanner(System.in);

        System.out.println("Factorial calculation");
        System.out.println("Provide n");

        int n = scanner.nextInt();

        System.out.println("calculateFactorialUsingRecursion result: " + calculateFactorialUsingRecursion(n));
        System.out.println("calculateFactorialUsingLoop result: " + calculateFactorialUsingLoop(n));
    }

    public static int calculateFactorialUsingRecursion(int n) {
        return n > 0 ? n * calculateFactorialUsingRecursion(n -1) : 1;
    };

    public static int calculateFactorialUsingLoop(int n) {
        int factorial = 1;
        while(n > 0) {
            factorial *= n;
            n--;
        }
        return factorial;
    };
}
