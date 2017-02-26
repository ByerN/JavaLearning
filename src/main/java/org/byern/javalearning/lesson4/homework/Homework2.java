package org.byern.javalearning.lesson4.homework;

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
        System.out.println("Recursion: ");
        for (int n = -1; n < 10; n++) {
            System.out.println("n==" + n + " result: " + calculateFactorialUsingRecursion(n));
        }
        System.out.println("Loop: ");
        for (int n = -1; n < 10; n++) {
            System.out.println("n==" + n + " result: " + calculateFactorialUsingLoop(n));
        }
    }


    public static int calculateFactorialUsingRecursion(int n) {
        if (n < 1) {
            return 1;
        } else {
            return n * calculateFactorialUsingRecursion(n - 1);
        }
    }

    public static int calculateFactorialUsingLoop(int n) {
        int result = 1;
        for (; n > 0; n--) {
            result *= n;
        }
        return result;
    }
}
