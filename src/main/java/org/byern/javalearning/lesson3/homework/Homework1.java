package org.byern.javalearning.lesson3.homework;

import java.util.Scanner;

/**
 * Created by ByerN on 22.02.2017.
 */
public class Homework1 {

    public static void main(String[] args) throws InterruptedException {
        /*
         * Replace if-else construction with looping through array.
         *
         * -play whole animation n-times -> n provided as input
         */

        String[][] arrow = {
                {" ", " ", "x", " ", " "},
                {" ", "x", "x", "x", " "},
                {"x", "x", "x", "x", "x"},
                {" ", "x", "x", "x", " "},
                {" ", "x", "x", "x", " "},
                {" ", "x", "x", "x", " "},
                {" ", "x", "x", "x", " "},
                {" ", "x", "x", "x", " "},
                {" ", "x", "x", "x", " "},
                {" ", "x", "x", "x", " "}
        };

        Scanner scanner = new Scanner(System.in); //Creates input to our program

        System.out.println("How many times would you like to play the animation?");
        System.out.print("n = ");
        int n = scanner.nextInt();

        while (n>0) {
            for (int y = 0; y < arrow.length; y++) {
                for (int x = 0; x < arrow[y].length; x++) {
                    System.out.print(arrow[y][x]);
                }
                Thread.sleep(300);
                System.out.println();
            }
            n--;
        }

    }

}
