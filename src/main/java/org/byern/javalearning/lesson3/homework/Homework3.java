package org.byern.javalearning.lesson3.homework;

import java.util.Random;

/**
 * Created by ByerN on 22.02.2017.
 */
public class Homework3 {

    public static final int VIEWPORT_X = 100;
    public static final int VIEWPORT_Y = 30;
    public static final double PROBE = 0.001;

    public static void main(String[] args) {
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
         */

        Random random = new Random();
        boolean[][] mapArray = new boolean[VIEWPORT_Y][VIEWPORT_X];

        int x1 = random.nextInt(VIEWPORT_X);
        int y1 = random.nextInt(VIEWPORT_Y);

        int r1 = random.nextInt(Math.min(VIEWPORT_X, VIEWPORT_Y));

        for(double t = 0; t<=Math.PI * 2 ; t+= PROBE){
            int calculatedX = (int) (x1 + Math.cos(t) * r1);
            int calculatedY = (int) (y1 + Math.sin(t) * r1);


            if(calculatedX >=0 && calculatedX < VIEWPORT_X &&
                    calculatedY >=0 && calculatedY < VIEWPORT_Y){
                mapArray[calculatedY][calculatedX] = true;
            }
        }

        for (int y = 0; y < VIEWPORT_Y; y++) {
            for (int x = 0; x < VIEWPORT_X; x++) {
                if(y==y1 && x == x1){
                    System.out.print("X");
                } else if(mapArray[y][x]){
                    System.out.print("+");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
