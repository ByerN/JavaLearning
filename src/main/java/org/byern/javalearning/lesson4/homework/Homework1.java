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

        //1. recursion
        System.out.println("Który element ciągu Fibonacciego podać:?");
        Scanner scanner = new Scanner(System.in);
        int ile = Integer.parseInt(scanner.next());
        System.out.println("Recurrsion: "+fib(ile));
        System.out.println("Looping: "+fib_looping(ile));

    }

    private static int fib(int ile) {
        if (ile == 1) {
            return 1;
        }
        if (ile == 0) {
            return 0;
        } else return (fib(ile - 2) + fib(ile - 1));
    }

    private static int fib_looping(int ile)
    {
        int f_a = 0;
        int f_z = 1;
        int tmp =0;
        //2. looping
        for (int i = 1; i < ile; i++) {//after each loop we have i item of fibonacci stream
                tmp = f_a + f_z;
                f_a = f_z;
                f_z = tmp;
        }

        return f_z;
    }

}
