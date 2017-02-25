package org.byern.javalearning.lesson3.homework;

import java.util.Scanner;

/**
 * Created by ByerN on 22.02.2017.
 */
public class Homework4 {
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

    public static final int VIEWPORT_X = 100;
    public static final int VIEWPORT_Y = 30;
    public static final double PROBE = 0.001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] line = new String[VIEWPORT_Y][VIEWPORT_X];

        System.out.print("a: ");
        int ax = scanner.nextInt();
        int ay = scanner.nextInt();

        System.out.print("b: ");
        int bx = scanner.nextInt();
        int by = scanner.nextInt();

        System.out.print("c: ");
        int cx = scanner.nextInt();
        int cy = scanner.nextInt();

        System.out.print("d: ");
        int dx = scanner.nextInt();
        int dy = scanner.nextInt();

        for (int i = 0; i < VIEWPORT_Y; i++) {
            for (int j = 0; j < VIEWPORT_X; j++) {
                line[i][j] = " ";
            }
        }

        for (double t = 0; t <= 1; t += PROBE) {
            int valueX = (int)Math.round(ax * Math.pow(1 - t, 3) + 3 * bx * t * Math.pow(1 - t, 2) + 3 * cx * Math.pow(t, 2) * (1 - t) + dx * Math.pow(t, 3));
            int valueY = (int)Math.round(ay * Math.pow(1 - t, 3) + 3 * by * t * Math.pow(1 - t, 2) + 3 * cy * Math.pow(t, 2) * (1 - t) + dy * Math.pow(t, 3));

            line[valueX][valueY] = "+";
        }

        line[ax][ay] = "A";
        line[bx][by] = "B";
        line[cx][cy] = "C";
        line[dx][dy] = "D";

        for (int i = 0; i < VIEWPORT_Y; i++) {
            for (int j = 0; j < VIEWPORT_X; j++) {
                System.out.print(line[i][j]);
            }
            System.out.println();
        }
    }
}
