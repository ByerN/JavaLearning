package org.byern.javalearning.lesson3.homework;

import java.util.Random;

/**
 * Created by ByerN on 22.02.2017.
 */
public class Homework3 {

    public static final int VIEWPORT_X = 100;
    public static final int VIEWPORT_Y = 30;
    public static final double PROBE = 0.001;
    public static final int radius = 5;

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
         * -Random.nextInt(n)
         */

        int thickness = 1;

        for (int j = 0; j<VIEWPORT_Y+radius*2 + thickness;j++)
        {
            for (int i = 0; i<VIEWPORT_X+radius*2+thickness; i++)
            {
                if ( Math.abs(Math.pow(Math.pow(i-VIEWPORT_X,2) + Math.pow(j-VIEWPORT_Y,2),.5) - radius*2) < thickness)
                {
                    System.out.print("+");
                }
                else if(i==VIEWPORT_X&&j==VIEWPORT_Y){
                    System.out.print("X");
                }
                else
                {
                    System.out.print(" ");
                }
                //System.out.print("\n");
            }
            System.out.print("\n");
        }


    }



}
