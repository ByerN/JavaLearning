package org.byern.javalearning.lesson4.homework;

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

        System.out.println("Recursion: ");
        for (int n = -1; n < 10; n++) {
            System.out.println("n==" + n + " result: " + calculateFibonacciNumberUsingRecursion(n));
        }
        System.out.println("Loop: ");
        for (int n = -1; n < 10; n++) {
            System.out.println("n==" + n + " result: " + calculateFibonacciNumberUsingLoop(n));
        }
    }

    public static int calculateFibonacciNumberUsingRecursion(int iteration) {
        int result = iteration;
        if (iteration > 1) {
            result = calculateFibonacciNumberUsingRecursion(iteration - 2) +
                    calculateFibonacciNumberUsingRecursion(iteration - 1);
        } else if (iteration < 0) {
            result = 0;
        }
        return result;
    }

    public static int calculateFibonacciNumberUsingLoop(int iteration) {
        int result = 0;
        if (iteration > 0) {
            int previous = 0;
            int next = 1;
            for (int n = 0; n < iteration; n++) {
                result = previous + next;
                previous = next;
                next = result;
            }
            result = previous;
        }
        return result;
    }
}
