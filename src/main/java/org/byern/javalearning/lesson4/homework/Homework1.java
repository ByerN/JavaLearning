package org.byern.javalearning.lesson4.homework;

/**
 * Created by ByerN on 26.02.2017.
 * Edited by Konrad
 */
 
import java.util.Scanner;  
 
public class Homework1 {
	
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

	public static void calculateFibonacciNumberUsingLoop(int n) {
		int result = 0;
		
		if (n == 0) result = 0;
		else if (n == 1) result = 1;
		else {
			int resultY = 0;
			int resultX = 1;
			for (int i = 2; i <= n; i++) {
				result = resultX + resultY;
				resultY = resultX;
				resultX = result;
			}
		}
		
		System.out.println("Fibonacci number using loop: "+result);
	}
	
	public static int calculateFibonacciNumberUsingRecursion(int n) {
		int result;

		if (n == 0) result = 0;
		else if (n == 1) result = 1;
		else {
            int resultY = calculateFibonacciNumberUsingRecursion(n-2);
            int resultX = calculateFibonacciNumberUsingRecursion(n-1);
            result = resultX + resultY;
        }

		return result;
	}

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Provide n: ");
        int n = input.nextInt();
		if (n < 0) n = 0;

        System.out.println("Fibonacci number using recursion: "+calculateFibonacciNumberUsingRecursion(n));
        calculateFibonacciNumberUsingLoop(n); 
    }
}
