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

        System.out.println("Fibonacci numbers using loop:");
        System.out.println("n = -1, Fibonacci Number: " + calculateFibonacciNumberUsingLoop(-1));
        System.out.println("n = 0, Fibonacci Number: " + calculateFibonacciNumberUsingLoop(0));
        System.out.println("n = 1, Fibonacci Number: " + calculateFibonacciNumberUsingLoop(1));
        System.out.println("n = 2, Fibonacci Number: " + calculateFibonacciNumberUsingLoop(2));
        System.out.println("n = 3, Fibonacci Number: " + calculateFibonacciNumberUsingLoop(3));
        System.out.println("n = 4, Fibonacci Number: " + calculateFibonacciNumberUsingLoop(4));
        System.out.println("n = 5, Fibonacci Number: " + calculateFibonacciNumberUsingLoop(5));
        System.out.println("n = 6, Fibonacci Number: " + calculateFibonacciNumberUsingLoop(6));
        System.out.println("n = 7, Fibonacci Number: " + calculateFibonacciNumberUsingLoop(7));
        System.out.println();
        System.out.println("Fibonacci numbers using recursion:");
        System.out.println("n = -1, Fibonacci Number: " + calculateFibonacciNumberUsingRecursion(-1));
        System.out.println("n = 0, Fibonacci Number: " + calculateFibonacciNumberUsingRecursion(0));
        System.out.println("n = 1, Fibonacci Number: " + calculateFibonacciNumberUsingRecursion(1));
        System.out.println("n = 2, Fibonacci Number: " + calculateFibonacciNumberUsingRecursion(2));
        System.out.println("n = 3, Fibonacci Number: " + calculateFibonacciNumberUsingRecursion(3));
        System.out.println("n = 4, Fibonacci Number: " + calculateFibonacciNumberUsingRecursion(4));
        System.out.println("n = 5, Fibonacci Number: " + calculateFibonacciNumberUsingRecursion(5));
        System.out.println("n = 6, Fibonacci Number: " + calculateFibonacciNumberUsingRecursion(6));
        System.out.println("n = 7, Fibonacci Number: " + calculateFibonacciNumberUsingRecursion(7));
    }

    public static int calculateFibonacciNumberUsingLoop(int n){
        if (n <= 0) {
            return 0;
        }else if (n == 1){
            return 1;
        }else {
            int fPreview = 0;
            int fCurrent = 1;
            int temp = 0;

            for (int i=0; i<n-1; i++){
                temp = fPreview + fCurrent;
                fPreview = fCurrent;
                fCurrent = temp;
            }
            return fCurrent;
        }
    }
    
    public static int calculateFibonacciNumberUsingRecursion(int n){
        if (n <= 0) {
            return 0;
        }else if (n == 1){
            return 1;
        }else {
            int fCurrent = calculateFibonacciNumberUsingRecursion(n-2)+calculateFibonacciNumberUsingRecursion(n-1);
            return  fCurrent;
        }

    }
}
