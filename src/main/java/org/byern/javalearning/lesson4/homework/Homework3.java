package org.byern.javalearning.lesson4.homework;

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
Example output (3 iterations):
XXXXXXXXXXXXXXXXXXXXXXXXXXX
X XX XX XX XX XX XX XX XX X
XXXXXXXXXXXXXXXXXXXXXXXXXXX
XXX   XXXXXX   XXXXXX   XXX
X X   X XX X   X XX X   X X
XXX   XXXXXX   XXXXXX   XXX
XXXXXXXXXXXXXXXXXXXXXXXXXXX
X XX XX XX XX XX XX XX XX X
XXXXXXXXXXXXXXXXXXXXXXXXXXX
XXXXXXXXX         XXXXXXXXX
X XX XX X         X XX XX X
XXXXXXXXX         XXXXXXXXX
XXX   XXX         XXX   XXX
X X   X X         X X   X X
XXX   XXX         XXX   XXX
XXXXXXXXX         XXXXXXXXX
X XX XX X         X XX XX X
XXXXXXXXX         XXXXXXXXX
XXXXXXXXXXXXXXXXXXXXXXXXXXX
X XX XX XX XX XX XX XX XX X
XXXXXXXXXXXXXXXXXXXXXXXXXXX
XXX   XXXXXX   XXXXXX   XXX
X X   X XX X   X XX X   X X
XXX   XXXXXX   XXXXXX   XXX
XXXXXXXXXXXXXXXXXXXXXXXXXXX
X XX XX XX XX XX XX XX XX X
XXXXXXXXXXXXXXXXXXXXXXXXXXX

Example output (2 iterations):
XXXXXXXXX
X XX XX X
XXXXXXXXX
XXX   XXX
X X   X X
XXX   XXX
XXXXXXXXX
X XX XX X
XXXXXXXXX

Example output (1 iterations):
XXXXXXXXX
XXXXXXXXX
XXXXXXXXX
XXX   XXX
XXX   XXX
XXX   XXX
XXXXXXXXX
XXXXXXXXX
XXXXXXXXX
         */
        boolean[][] sierpinskiCarpetArray = createSierpinskiCarpet(
                (int) Math.pow(3, 4),
                (int) Math.pow(3, 4),
                4
        );
        for (int y = 0; y < sierpinskiCarpetArray.length; y++) {
            for (int x = 0; x < sierpinskiCarpetArray[y].length; x++) {
                System.out.print(!sierpinskiCarpetArray[y][x] ? "X" : " ");
            }
            System.out.println();
        }
    }

    public static boolean[][] createSierpinskiCarpet(int width, int height, int iterationNumber) {
        boolean[][] result = new boolean[width][height];
        createSierpinskiCarpet(0, 0, width, height, result, iterationNumber);
        return result;
    }

    public static void createSierpinskiCarpet(int rectX,
                                              int rectY,
                                              int width,
                                              int height,
                                              boolean[][] array,
                                              int iterationNumber) {
        iterationNumber--;
        if (iterationNumber < 0) {
            return;
        }
        int centerWidth = width / 3;
        int centerHeight = height / 3;
        int centerX = rectX + centerWidth;
        int centerY = rectY + centerHeight;

        //Fill the center
        for (int y = centerY; y < centerY + centerHeight; y++) {
            for (int x = centerX; x < centerX + centerWidth; x++) {
                if (y >= 0 && y < array.length && x >= 0 && x < array[y].length) {
                    array[y][x] = true;
                }
            }
        }

        //Recursive call other rectangles
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (!(y == 1 && x == 1)) {
                    createSierpinskiCarpet(
                            rectX + x * centerWidth,
                            rectY + y * centerHeight,
                            centerWidth,
                            centerHeight,
                            array,
                            iterationNumber
                    );
                }
            }
        }
    }

}
