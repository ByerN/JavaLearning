package org.byern.javalearning.lesson3.homework;


import java.util.Random;

public class Homework3_Asia {

    public static final int VIEWPORT_X = 100;
    public static final int VIEWPORT_Y = 30;
    public static final double PROBE = 0.001;


    public static void main(String[] args) {

        Random random = new Random();

        String map[][] = new String[VIEWPORT_Y][VIEWPORT_X];

        int x = random.nextInt(VIEWPORT_X);
        int y = random.nextInt(VIEWPORT_Y);


        int minR = Math.min(VIEWPORT_X, VIEWPORT_Y);
        int r = random.nextInt(minR) / 2;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = " ";
            }
        }

        map[r][r] = "X";

        for (double fi = 0; fi <= 2 * (Math.PI); fi += PROBE) {
            int y1 = (int) (r * (Math.sin(fi)));
            int x1 = (int) (r * (Math.cos(fi)));
            map[y1 + r][x1 + r] = "x";
        }


        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

}
