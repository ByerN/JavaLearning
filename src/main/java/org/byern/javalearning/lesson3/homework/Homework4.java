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
         *
         */
        Random random = new Random();
        boolean[][] mapArray = new boolean[VIEWPORT_Y][VIEWPORT_X];

        int x1 = random.nextInt(VIEWPORT_X);
        int y1 = random.nextInt(VIEWPORT_Y);

        int x2 = random.nextInt(VIEWPORT_X);
        int y2 = random.nextInt(VIEWPORT_Y);

        int x3 = random.nextInt(VIEWPORT_X);
        int y3 = random.nextInt(VIEWPORT_Y);

        int x4 = random.nextInt(VIEWPORT_X);
        int y4 = random.nextInt(VIEWPORT_Y);

        for(double t = 0; t<=1 ; t+= PROBE){
            int calculatedX = (int) (
                    x1 * Math.pow((1-t), 3) +
                    3 * x2 * t * Math.pow((1-t), 2) +
                    3 * x3 * Math.pow(t, 2) * (1-t) +
                    x4 * Math.pow(t, 3)
            );
            int calculatedY = (int) (
                    y1 * Math.pow((1-t), 3) +
                    3 * y2 * t * Math.pow((1-t), 2) +
                    3 * y3 * Math.pow(t, 2) * (1-t) +
                    y4 * Math.pow(t, 3)
            );

            if(calculatedX >=0 && calculatedX < VIEWPORT_X &&
                calculatedY >=0 && calculatedY < VIEWPORT_Y){
                mapArray[calculatedY][calculatedX] = true;
            }
        }

        for (int y = 0; y < VIEWPORT_Y; y++) {
            for (int x = 0; x < VIEWPORT_X; x++) {
                if(y==y1 && x == x1){
                    System.out.print("A");
                } else if(y==y2 && x == x2){
                    System.out.print("B");
                } else if(y==y3 && x == x3){
                    System.out.print("C");
                } else if(y==y4 && x == x4){
                    System.out.print("D");
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
