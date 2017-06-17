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
         * Draw random ASCII circle
         *
         * -Can be cut on the viewport edges.
         * -Center has to be in viewport
         *
         * Hints:
         * -2d array can be useful.
         * -Math.cos
         * -Math.sin
         * -Math.PI (constant)
         * -Random.nextInt(n)
         */
        int xI = 0, yI = 0, r = 0;
        Random random = new Random();

        xI = random.nextInt(VIEWPORT_X);
        yI = random.nextInt(VIEWPORT_Y);
        r = random.nextInt(VIEWPORT_X);
        int xP = 0, yP = 0;
        char[][] screen_ch = new char[VIEWPORT_X][VIEWPORT_Y];
        screen_ch[xI][yI] = 'x'; //circle centre
        //math relation
        //x = r cos(t) + xI
        //y = r sin(t) + yI
        //filling the screen matrix
        for (int t = 0; t < 360; t++) {
            xP = xI + (int) (r * Math.cos(t));
            yP = yI + (int) (r * Math.sin(t));
            if ((xP < VIEWPORT_X) && (yP < VIEWPORT_Y) && (xP > 0) && (yP > 0)) {
                screen_ch[xP][yP] = '+';
            }
        }

//drawing
        for (int x = 0; x < VIEWPORT_X; x++) {
            for (int y = 0; y < VIEWPORT_Y; y++) {
                System.out.print(screen_ch[x][y]);
            }
            System.out.println();
        }
    }

}
