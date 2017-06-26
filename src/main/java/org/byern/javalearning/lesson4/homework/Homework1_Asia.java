package org.byern.javalearning.lesson4.homework;

public class Homework1_Asia {

    public static void main(String[] args) {
        /*
         * Create 2 methods for Fibonacci numbers calculation
         * 1. using recursion
         * 2. using loop
         *
         * int calculateFibonacciNumberUsingRecursion(int n)
         * int calculateFibonacciNumberUsingLoop(int n)
         *
         * n -> indicates which number to calculate
         *
         * -non-positive numbers can be treated like 0
         */
        int n = 7;
        int fibonacciLoopResultList = calculateFibonacciNumberUsingLoop(n);

        int fibonacciResult = fibonacciRecursion(n);

        System.out.println(n + "th word of the sequence for Fibonacci using recursion to: " + fibonacciResult);
        System.out.println(n + "th word of the sequence for Fibonacci using loop to: " + fibonacciLoopResultList);
    }


    public static int fibonacciRecursion(int n) {
        if (n < 3) {
            return 1;
        }
        int result = fibonacciRecursion(n - 2) + fibonacciRecursion(n - 1);

        return result;
    }


    public static int calculateFibonacciNumberUsingLoop(int n) {
        int a = 0;
        int b = 1;

        for (int i = 0; i < n; i++) {
            b += a;
            a = b - a;
        }
        return a;
    }
}