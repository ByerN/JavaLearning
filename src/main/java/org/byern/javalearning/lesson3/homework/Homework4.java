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

        String[][] area = new String[VIEWPORT_Y][VIEWPORT_X];

        Random random = new Random();

        //Curve Points calculation
        int ax=0;
        int ay=random.nextInt(VIEWPORT_Y)-((VIEWPORT_Y/2)-1);
        int bx=random.nextInt(VIEWPORT_X/2);
        int by=random.nextInt(VIEWPORT_Y)-((VIEWPORT_Y/2)-1);
        int cx=random.nextInt(VIEWPORT_X/2)+(VIEWPORT_X/2);
        int cy=random.nextInt(VIEWPORT_Y)-((VIEWPORT_Y/2)-1);
        int dx=VIEWPORT_X-1;
        int dy=random.nextInt(VIEWPORT_Y)-(VIEWPORT_Y/2-1);

        for(int y=0; y<area.length; y++){
            for (int x=0; x<area[y].length; x++){
                area[y][x] = " ";
            }
        }

        for(double i=0; i<1; i+=PROBE){
            int y = (int)Math.round((ay*Math.pow((1-i),3)+3*by*i*Math.pow((1-i),2)+3*cy*Math.pow(i,2)*(1-i)+dy*Math.pow(i,3)));
            int x = (int)Math.round((ax*Math.pow((1-i),3)+3*bx*i*Math.pow((1-i),2)+3*cx*Math.pow(i,2)*(1-i)+dx*Math.pow(i,3)));
            y+=((VIEWPORT_Y/2)-1); //The Bezier curve is moved to the graph part with positive values (to fit into area[][])

            if (x>=0 && x<VIEWPORT_X && y>=0 && y<VIEWPORT_Y){
                area[y][x] = "+";
            }
        }

        //adding Curve points to the array
        area[ay+((VIEWPORT_Y/2)-1)][ax] = "A";
        area[by+((VIEWPORT_Y/2)-1)][bx] = "B";
        area[cy+((VIEWPORT_Y/2)-1)][cx] = "C";
        area[dy+((VIEWPORT_Y/2)-1)][dx] = "D";

        for(int y=0; y<area.length; y++){
            for (int x=0; x<area[y].length; x++){
                System.out.print(area[y][x]);
            }
            System.out.println();
        }
    }

}
