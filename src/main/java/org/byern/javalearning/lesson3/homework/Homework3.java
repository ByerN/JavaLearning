package org.byern.javalearning.lesson3.homework;

import javax.swing.text.View;
import java.util.Random;

/**
 * Created by ByerN on 22.02.2017.
 */
public class Homework3 {

    public static final int VIEWPORT_X = 100;
    public static final int VIEWPORT_Y = 30;

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

        int a = VIEWPORT_X / 2;
        int b = VIEWPORT_Y / 2;
        int r = new Random().nextInt(VIEWPORT_Y);

        String[][] printArray = new String[VIEWPORT_X][VIEWPORT_Y];

        for (int x = 0; x < VIEWPORT_X; x++) {
            for (int y = 0; y < VIEWPORT_Y; y++) {
                int leftSide = (x - a) * (x - a) + (y - b) * (y - b) ;
                int rightSide = r*r;
                if (Math.abs(leftSide - rightSide) < r){
                    printArray[x][y] = "+";
                }else{
                    printArray[x][y] = " ";
                }
            }
        }
        printArray[a][b] = "X";

        //It was lesson for tables and loops. Instead I would just print in loop above

        for (int y = 0; y < VIEWPORT_Y; y++) {
            for (int x = 0; x < VIEWPORT_X; x++) {
                System.out.print(printArray[x][y]);
            }
            System.out.println("");
        }
    }

}
