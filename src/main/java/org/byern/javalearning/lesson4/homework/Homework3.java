package org.byern.javalearning.lesson4.homework;

import java.util.Scanner;

/**
 * Created by ByerN on 26.02.2017.
 */
public class Homework3 {

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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Provide carpet width");
        int width = scanner.nextInt();
        System.out.println("Provide carpet height");
        int height = scanner.nextInt();
        System.out.println("Provide iteration number");
        int iterationNumber = scanner.nextInt();

        boolean [][] carpet = createSierpinskiCarpet(width, height, iterationNumber);

        for(int row = 0; row < height; row++) {
            for(int column = 0; column < width; column++) {
                System.out.print(carpet[row][column] ? ' ': '*');
            }
            System.out.println();
        }
    }

    public static boolean[][] createSierpinskiCarpet(int width, int height, int iterationNumber) {
        int thirdOfWidth = width/3;
        int thirdOfHeight = height/3;
        boolean [][] carpet = new boolean[height][width];

        if (iterationNumber > 1 && width > 3 && height > 3) {
            boolean[][] carpet2 = createSierpinskiCarpet(thirdOfWidth, thirdOfHeight, iterationNumber - 1);

            for (int row = 0; row < height; row++) {
                for (int column = 0; column < width; column++) {
                    carpet[row][column] = carpet2[row % thirdOfHeight][column % thirdOfWidth];
                }
            }
        }

        for(int row = thirdOfHeight; row < thirdOfHeight*2; row++) {
            for (int column = thirdOfWidth; column < thirdOfWidth*2; column++) {
                carpet[row][column] = true;
            }
        }

        return carpet;
    };
}
