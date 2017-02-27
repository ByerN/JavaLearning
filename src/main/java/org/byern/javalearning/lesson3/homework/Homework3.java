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
    int x_i=0,y_i=0,r=0;
    Random random = new Random();

    x_i = random.nextInt(VIEWPORT_X);
    y_i = random.nextInt(VIEWPORT_Y);
    r = random.nextInt(VIEWPORT_X);
    int x_p=0, y_p=0;
    char[][] screen_ch = new char[VIEWPORT_X][VIEWPORT_Y];
    screen_ch[x_i][y_i]='x'; //circle centre
        //math relation
        //x = r cos(t) + x_i
        //y = r sin(t) + y_i
        //filling the screen matrix
        for (int t=0;t<360;t++){
        x_p = x_i + (int) (r* Math.cos(t));
        y_p = y_i + (int) (r* Math.sin(t));
        if ((x_p<VIEWPORT_X) && (y_p<VIEWPORT_Y) &&(x_p>0) && (y_p>0)) {
            screen_ch[x_p][y_p]='+';
            }
        }

//drawing
    for (int x=0;x<VIEWPORT_X;x++){
        for (int y=0; y<VIEWPORT_Y; y++){
            System.out.print(screen_ch[x][y]);
        }
        System.out.println();
    }
    }

}
