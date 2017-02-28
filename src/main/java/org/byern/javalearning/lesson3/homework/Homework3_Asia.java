package org.byern.javalearning.lesson3.homework;


import java.util.Random;

public class Homework3_Asia {

    public static final int VIEWPORT_X = 100;
    public static final int VIEWPORT_Y = 30;
    public static final double PROBE = 0.001;


    public static void main(String[] args) {

        Random random = new Random();

        String map[][] = new String [VIEWPORT_Y][VIEWPORT_X];

        int x = random.nextInt(VIEWPORT_X);
        int y = random.nextInt(VIEWPORT_Y);


        int minR = Math.min(VIEWPORT_X, VIEWPORT_Y);
        int r = random.nextInt(minR);



        for(double fi = 0; fi <= 2*(Math.PI); fi+=PROBE){
            int x1 = (int) (r * (Math.cos(fi)));
            int y1 = (int) (r * (Math.sin(fi)));


            if(x1<x && y1<y){
                map[x1][y1] = "x";
            }

        }


        for(int a = 0; a < VIEWPORT_Y; a++){
            for(int b = 0; b < VIEWPORT_Y; b++){
                if(a == x && b == y){
                    System.out.println("x");
                }
                else {
                    System.out.println(" ");
                }
            }
            System.out.println();
        }

    }

}
