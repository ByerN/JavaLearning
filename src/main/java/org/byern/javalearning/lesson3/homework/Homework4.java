package org.byern.javalearning.lesson3.homework;

import java.util.Random;

/**
 * Created by ByerN on 22.02.2017.
 */
public class Homework4 {

    public static final int VIEWPORT_X = 100;
    public static final int VIEWPORT_Y = 30;
    public static final double PROBE = 0.001;

    public static void main(String[] args) {
        /*
         * Draw random ASCII Cubic Bezier curve
         * https://pl.wikipedia.org/wiki/Krzywa_B%C3%A9ziera
         *
         * -Can be cut on the viewport edges.
         * Example output:
         *






                                                                        +++A
                                                                      +++
                                                                    +++
     D++                                                          +++
       +++                                                       ++
         +++                                                   ++
           ++++                                              +++
              +++                                          +++
                ++++                                    ++++
                   ++++                               +B+
                      +++++                        ++++
                          +++++                +++++
                               +++++++++++++++++









                                             C
         *
         * A,B,C,D -> Curve points (optional to render)
         *
         * Hints:
         * -2d array can be useful.
         * -Math.pow
         * -Random.nextInt(n)
         */

        int a = VIEWPORT_X / 2;
        int b = VIEWPORT_Y / 2;
        Random random = new Random();
        int Ax = random.nextInt(VIEWPORT_X);
        int Ay = random.nextInt(VIEWPORT_Y);
        int Bx = random.nextInt(VIEWPORT_X);
        int By = random.nextInt(VIEWPORT_Y);
        int Cx = random.nextInt(VIEWPORT_X);
        int Cy = random.nextInt(VIEWPORT_Y);
        int Dx = random.nextInt(VIEWPORT_X);
        int Dy = random.nextInt(VIEWPORT_Y);

        String[][] printArray = new String[VIEWPORT_X][VIEWPORT_Y];

        for (int x = 0; x < VIEWPORT_X; x++) {
            for (int y = 0; y < VIEWPORT_Y; y++) {
                printArray[x][y] = " ";
            }
        }

        for (double t = 0; t <= 1; t += PROBE) {
            int valX = (int) (Ax * Math.pow(1 - t, 3)
                    + 3 * Bx * t * Math.pow(1 - t, 2)
                    + 3 * Cx * t * t * (1 - t)
                    + Dx * Math.pow(t, 3));

            int valY = (int) (Ay * Math.pow(1 - t, 3)
                    + 3 * By * t * Math.pow(1 - t, 2)
                    + 3 * Cy * t * t * (1 - t)
                    + Dy * Math.pow(t, 3));

            if (valX > 0 && valX < VIEWPORT_X && valY > 0 && valY < VIEWPORT_Y) {
                printArray[valX][valY] = "+";
            }
        }

        printArray[Ax][Ay] = "A";
        printArray[Bx][By] = "B";
        printArray[Cx][Cy] = "C";
        printArray[Dx][Dy] = "D";

        for (int y = 0; y < VIEWPORT_Y; y++) {
            for (int x = 0; x < VIEWPORT_X; x++) {
                System.out.print(printArray[x][y]);
            }
            System.out.println("");
        }
    }
}
