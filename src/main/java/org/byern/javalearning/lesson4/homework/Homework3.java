package org.byern.javalearning.lesson4.homework;

import java.util.Scanner;

/**
 * Created by ByerN on 26.02.2017.
 */
public class Homework3 {

    static int INITIAL_SQUARE = 9;
    static boolean[] carpet = new boolean[INITIAL_SQUARE];//false == black (by default), true == white

    public static void main(String[] args) {
        /*
         * Make a method returning array representing Sierpinski carpet
         * and print it's result.
         *
         * boolean[][] createSierpinskiCarpet(int width, int height, int iterationNumber)
         *
         * width/height -> size o the returned array.
         * iterationNumber -> number of Sierpinski carpet iterations
         *
         * Assume that width and height is power of 3
         *
         */
        System.out.println("Podaj wielkosc:");
        Scanner scanner = new Scanner(System.in);
        //int size = Integer.parseInt(scanner.next());

        carpet(INITIAL_SQUARE);
        draw_carpet();
    }

    static boolean[] carpet(int size) {

        for (int i = size / 3; i < 2 * size / 3; i++) {
            carpet[i] = true;
        }

        return carpet ;
    }


    private static void draw_carpet() {
        for (int i = 0; i < INITIAL_SQUARE; i++) {
            if (carpet[i] == true) {
                System.out.print(" ");
            } else {
                System.out.print("x");
            }
//            System.out.println();//new line
        }
    }
}
