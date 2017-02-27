package org.byern.javalearning.lesson3.homework;

import java.util.Random;

public class Homework4 {

    public static final int VIEWPORT_X = 100;
    public static final int VIEWPORT_Y = 30;
    public static final double COUNTER = 100;

    public static void main(String[] args) {

        Random rand = new Random();

        double t;
        int x, y;
        int x1 = rand.nextInt(VIEWPORT_Y);
        int y1 = rand.nextInt(VIEWPORT_X);
        int x2 = rand.nextInt(VIEWPORT_Y);
        int y2 = rand.nextInt(VIEWPORT_X);
        int x3 = rand.nextInt(VIEWPORT_Y);
        int y3 = rand.nextInt(VIEWPORT_X);
        int x4 = rand.nextInt(VIEWPORT_Y);
        int y4 = rand.nextInt(VIEWPORT_X);
        char[][] curve = new char[VIEWPORT_Y][VIEWPORT_X];

        for(int i = 0; i <= COUNTER; i++) {
            t = i / (float) COUNTER;
            x = (int)(Math.pow(1-t, 3) * x1 + 3 * Math.pow(1-t, 2) * t * x2 + 3 * Math.pow(1-t, 2) * Math.pow(t, 2) * x3 + Math.pow(t, 3) * x4);
            y = (int)(Math.pow(1-t, 3) * y1 + 3 * Math.pow((int)1-t, 2) * t * y2 + 3 * Math.pow(1-t, 2) * Math.pow(t, 2) * y3 + Math.pow(t, 3) * y4);
            curve[x][y] = '+';
        }

        curve[x1][y1] = 'A';
        curve[x2][y2] = 'B';
        curve[x3][y3] = 'C';
        curve[x4][y4] = 'D';

        for(int row = 0; row < VIEWPORT_Y; row++) {
            for(int column = 0; column < VIEWPORT_X; column++) {
                if(curve[row][column] == '+') {
                    System.out.print('+');
                } else if (curve[row][column] == 0) {
                    System.out.print(' ');
                } else {
                    System.out.print(curve[row][column]);
                }
            }
            System.out.println();
        }

//        PREVIOUS VERSION

//        Random rand = new Random();
//
//        double t;
//        int SEGMENT_COUNT = 100, row, column, x, y;
//        int[] P1 = {rand.nextInt(VIEWPORT_Y), rand.nextInt(VIEWPORT_X)};
//        int[] P2 = {rand.nextInt(VIEWPORT_Y), rand.nextInt(VIEWPORT_X)};
//        int[] P3 = {rand.nextInt(VIEWPORT_Y), rand.nextInt(VIEWPORT_X)};
//        int[] P4 = {rand.nextInt(VIEWPORT_Y), rand.nextInt(VIEWPORT_X)};
//        char[][] curve = new char[VIEWPORT_Y][VIEWPORT_X];
//
//        for(row = 0; row < VIEWPORT_Y; row++)
//        {
//            for(column = 0; column < VIEWPORT_X; column++)
//            {
//                curve[row][column] = ' ';
//            }
//        }
//
//        for(int i = 0; i <= COUNTER; i++)
//        {
//            t = i / (float) SEGMENT_COUNT;
//            x = (int)(Math.pow(1-t, 3) * P1[0] + 3 * Math.pow(1-t, 2) * t * P2[0] + 3 * Math.pow(1-t, 2) * Math.pow(t, 2) * P3[0] + Math.pow(t, 3) * P4[0]);
//            y = (int)(Math.pow(1-t, 3) * P1[1] + 3 * Math.pow((int)1-t, 2) * t * P2[1] + 3 * Math.pow(1-t, 2) * Math.pow(t, 2) * P3[1] + Math.pow(t, 3) * P4[1]);
//            curve[x][y] = '+';
//        }
//
//        curve[P1[0]][P1[1]] = 'A';
//        curve[P2[0]][P2[1]] = 'B';
//        curve[P3[0]][P3[1]] = 'C';
//        curve[P4[0]][P4[1]] = 'D';
//
//        for(row = 0; row < VIEWPORT_Y; row++)
//        {
//            for(column = 0; column < VIEWPORT_X; column++)
//            {
//                System.out.print(curve[row][column]);
//            }
//            System.out.println();
//        }

    }

}
