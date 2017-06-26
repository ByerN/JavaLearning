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
        System.out.println("Factorial using recursion:");
        System.out.println("n = -1, Factorial: " + calculateFactorialUsingRecursion(-1));
        System.out.println("n = 0, Factorial: " + calculateFactorialUsingRecursion(0));
        System.out.println("n = 1, Factorial: " + calculateFactorialUsingRecursion(1));
        System.out.println("n = 2, Factorial: " + calculateFactorialUsingRecursion(2));
        System.out.println("n = 3, Factorial: " + calculateFactorialUsingRecursion(3));
        System.out.println("n = 4, Factorial: " + calculateFactorialUsingRecursion(4));
        System.out.println("n = 5, Factorial: " + calculateFactorialUsingRecursion(5));
        System.out.println();
        System.out.println("Factorial using loop:");
        System.out.println("n = -1, Factorial: " + calculateFactorialUsingLoop(-1));
        System.out.println("n = 0, Factorial: " + calculateFactorialUsingLoop(0));
        System.out.println("n = 1, Factorial: " + calculateFactorialUsingLoop(1));
        System.out.println("n = 2, Factorial: " + calculateFactorialUsingLoop(2));
        System.out.println("n = 3, Factorial: " + calculateFactorialUsingLoop(3));
        System.out.println("n = 4, Factorial: " + calculateFactorialUsingLoop(4));
        System.out.println("n = 5, Factorial: " + calculateFactorialUsingLoop(5));


    }

    public static int calculateFactorialUsingRecursion(int n){

        if (n < 0) {
            return 0;
        } else if (n == 0){
            return 1;
        } else {
            int factorialResult = n * calculateFactorialUsingRecursion(n-1);
            return factorialResult;
        }
    }

    public static int calculateFactorialUsingLoop(int n){

        if (n < 0) {
            return 0;
        } else if (n == 0){
            return 1;
        } else {
            int factorialResult =1;
            for (int i = 1; i < n+1; i++){
                factorialResult *= i;
            }
            return factorialResult;
        }
    }
}
