package org.byern.javalearning.lesson3.homework;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by ByerN on 22.02.2017.
 */
public class Homework3 {
 /*
         * Draw random ASCII circle
         *
         * -Can be cut on the viewport edges.
         * -Center has to be in viewport
         *
         * Example output:
         *

                              ++++++
                             ++    ++
                             +      +
                             +      +
                             +   X  ++
                             +      +
                             ++    ++
                              ++++++

         * Example output:
                                        +                                +
                                       ++                                ++
                                       +                                  +
                                      ++                                  ++
                                      +                                    +
                                     ++                                    ++
                                     +                                      +
                                     +                                      +
                                     +                                      +
                                     +                                      +
                                     +                                      +
                                     +                                      +
                                     +                   X                  ++
                                     +                                      +
                                     +                                      +
                                     +                                      +
                                     +                                      +
                                     +                                      +
                                     ++                                    ++
                                      +                                    +
                                      ++                                  ++
                                       +                                  +
                                       ++                                ++
                                        +                                +
                                         +                              +
                                         ++                            ++
                                          ++                          ++
                                           ++                        ++
                                             ++                    ++
         * X -> center of the circle
         *
         *
         * Hints:
         * -2d array can be useful.
         * -Math.cos
         * -Math.sin
         * -Math.PI (constant)
         * -Random.nextInt(n)
         */

    private static final int VIEWPORT_X = 100;
    private static final int VIEWPORT_Y = 30;
    public static final double PROBE = 0.001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] circle = new String[VIEWPORT_Y][VIEWPORT_X];

        System.out.print("Provide x, y and r: ");
        int x = scanner.nextInt();//"random circle"
        int y = scanner.nextInt();
        int r = scanner.nextInt();

        for (int i = 0; i < VIEWPORT_Y; i++) {
            for (int j = 0; j < VIEWPORT_X; j++) {
                circle[i][j] = " ";
            }
        }

        for (int i = x - r; i < x + r; i++) {//Doesn't look like one from example but it's interesting
            for (int j = y - r; j < y + r; j++) {
                if (i > 0 && i < VIEWPORT_Y && j > 0 && j < VIEWPORT_X) {
                    double d = Math.round(Math.abs(Math.sqrt(Math.pow(i - x, 2) + Math.pow(j - y, 2))) - r);
                    if (Math.abs(d) <= 1) {
                        circle[i][j] = "+";
                    }
                }
            }
        }

        circle[x][y] = "x";

        for (int i = 0; i < VIEWPORT_Y; i++) {
            for (int j = 0; j < VIEWPORT_X; j++) {
                System.out.print(circle[i][j]);
            }
            System.out.println();
        }
    }
}
