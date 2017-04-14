package org.byern.javalearning.lesson4.homework;


public class Homework2_Asia {

    public static void main(String[] args) {
        /*
         * Create 2 methods for factorial calculation
         * 1. using recursion
         * 2. using loop
         *
         * int calculateFactorialUsingRecursion(int n)
         * int calculateFactorialUsingLoop(int n)
         *
         * n -> indicates which number to calculate
         *
         * -non-positive numbers can be treated like 0
         */

        int n = 4;
        int resultSilnia = calculateFactorialUsingRecursion(n);
        int resultLoop = calculateFactorialUsingLoop(n);

        System.out.printf("Result for factorialis %d and result for loop is %d", resultSilnia, resultLoop);

    }

    public static int calculateFactorialUsingRecursion(int n) {
        if (n < 1) {
            return 1;
        } else {
            return n * calculateFactorialUsingRecursion(n - 1);
        }
    }

    public static int calculateFactorialUsingLoop(int n) {
        int silnia = 1;
        for (int i = 1; i <= n; i++) {
            silnia = silnia * i;
        }
        return silnia;
    }
}




