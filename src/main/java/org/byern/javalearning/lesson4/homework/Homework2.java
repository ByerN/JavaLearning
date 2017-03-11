package org.byern.javalearning.lesson4.homework;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

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
        //1/ recursion

        System.out.println("Silnia:?");
        Scanner scanner = new Scanner(System.in);
        int ile = Integer.parseInt(scanner.next());
        System.out.println("Recurrecive: "+fractorial_r(ile));
        System.out.println("looping: "+fractoral_loopin(ile));
    }

    private static int fractoral_loopin(int ile) {
            int fractorial = 1;
        for (int i = ile ; ile>0;ile--)
        {
             fractorial *= ile;
        }
        return fractorial;
    }

    private static int fractorial_r(int ile) {
        if (ile == 0) return 1;
        if (ile == 1) return 1;
        return ((fractorial_r(ile - 1)) * (ile));
    }


}
