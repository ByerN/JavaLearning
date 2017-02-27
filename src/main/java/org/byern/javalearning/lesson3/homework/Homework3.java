package org.byern.javalearning.lesson3.homework;

import java.util.*;

/**
 * Created by ByerN on 22.02.2017.
 */
public class Homework3 {

    public static final int VIEWPORT_X = 100;
    public static final int VIEWPORT_Y = 30;
    public static final double PROBE = 0.0001;

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

        String[][] area = new String[VIEWPORT_Y][VIEWPORT_X];

        final int MIN = VIEWPORT_Y<VIEWPORT_X ? VIEWPORT_Y : VIEWPORT_X;
        Random randomno = new Random();
        int r = randomno.nextInt(MIN/2-1); //random radius

        for(int y=0; y<area.length; y++){
            for (int x=0; x<area[y].length; x++){
                area[y][x] = " ";
            }
        }

        area[r][r] = "X";

        for(double i=0; i<2*Math.PI; i+=PROBE){
             int y = (int)(r * Math.cos(i));
             int x = (int)(r * Math.sin(i));
             area[y+r][x+r] = "+";
        }

        for(int y=0; y<2*r+1; y++){
            for (int x=0; x<2*r+1; x++){
                System.out.print(area[y][x]);
            }
            System.out.println();
        }

    }

}
