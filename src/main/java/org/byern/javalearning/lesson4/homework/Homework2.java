package org.byern.javalearning.lesson4.homework;

/**
 * Created by ByerN on 26.02.2017.
 * Edited by Konrad
 */

import java.util.Scanner;

public class Homework2 {

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

	public static void calculateFactorialUsingLoop(int n) {
	    long result = 1;

	    if (!((n == 0) || (n == 1))) {
	        for (int i = 2; i <= n; i++) {
	            result = result * i;
            }
        }

        System.out.println("Factorial using loop: "+result);
    }

    public static long calculateFactorialUsingRecursion(int n) {
	    long result = 1;

        if (!((n == 0) || (n == 1))) {
            result = n * calculateFactorialUsingRecursion(n-1);
        }

	    return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Provide n: ");
        int n = input.nextInt();
        if (n < 0) n = 0;

        System.out.println("Fibonacci number using recursion: "+calculateFactorialUsingRecursion(n));
        calculateFactorialUsingLoop(n);

    }
}
