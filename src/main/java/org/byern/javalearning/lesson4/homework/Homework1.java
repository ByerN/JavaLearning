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
        System.out.println("How many Fibonacci numbers do you want to calculate?");
        int numbers = Integer.parseInt(scanner.next());
        System.out.println("\nLets print Fibonacci numbers to "+numbers+" values:");


        System.out.println("\n\n================== Use for loop: ================== ");
        int sum=0;
        int current=0;
        int previous=0;
        int next=1;
        for(int i=0; i<numbers; i++){
            System.out.println((i+1)+" Fibonacci previous = "+previous+ " | current = "+current+" | summ = "+sum);
            previous=sum-current;
            sum+=next;
            next+=current;
            current=next-current;
        }




        System.out.println("\n\n================== Use recursion: ==================");

        public static void recursionFibonacci(int numbers, int i, int sum, int current, int previous, int next) {
            System.out.println((i+1)+" Fibonacci previous = "+previous+ " | current = "+current+" | summ = "+sum);
            System.out.println(numbers);
        }

        recursionFibonacci(7,0,0,0,0,1);

    }
}
