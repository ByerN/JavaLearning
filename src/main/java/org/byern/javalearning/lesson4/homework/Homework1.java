package org.byern.javalearning.lesson4.homework;

import java.util.Scanner;

/**
 * Created by ByerN on 26.02.2017.
 */
public class Homework1 {

    public static void main(String[] args) {
        /*
         * Create 2 methods for Fibonacci numbers calculation
         * 1. using recursion
         * 2. using loop
         *
         * calculateFibonacciNumberUsingRecursion(int n)
         * calculateFibonacciNumberUsingLoop(int n)
         *
         * n -> indicates which number to calculate
         *
         * -non-positive numbers can be treated like 0
         */

        Scanner scanner = new Scanner(System.in);

        System.out.println("Fibonacci numbers calculation");
        System.out.println("Provide n");

        int n = scanner.nextInt();

        System.out.println("calculateFibonacciNumberUsingRecursion result: " + calculateFibonacciNumberUsingRecursion(n));
        System.out.println("calculateFibonacciNumberUsingLoop result: " + calculateFibonacciNumberUsingLoop(n));
    }

     public static int calculateFibonacciNumberUsingRecursion(int n) {
        if(n <= 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return calculateFibonacciNumberUsingRecursion(n-1) + calculateFibonacciNumberUsingRecursion(n-2);
        }
    };

     public static int calculateFibonacciNumberUsingLoop(int n) {
        if(n <= 0) {
            return  0;
        }

        int a = 0, b = 1, c = a + b;

        for(int i = 1; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    };
}
