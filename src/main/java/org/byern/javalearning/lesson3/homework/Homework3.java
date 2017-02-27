package org.byern.javalearning.lesson3.homework;

import java.util.Random;

public class Homework3 {

    public static final int VIEWPORT_X = 100;
    public static final int VIEWPORT_Y = 30;

    public static void main(String[] args) {

        Random rand = new Random();

        char[][] circle = new char[VIEWPORT_Y][VIEWPORT_X];
        int x, y, row, column;//don't use sequenced declaration. It's less readable.
        //x, y, row, column should be declared in their scope of use
        //they are not needed here
        int centerX = (int)(VIEWPORT_X/2);//casting not necessary
        int centerY = (int)(VIEWPORT_Y/2);
        int r = rand.nextInt((int)(Math.max(VIEWPORT_X, VIEWPORT_Y)/2));
        double angle;//declare variable where it's used

        for(row = 0; row < VIEWPORT_Y; row++)
        {
            for(column = 0; column < VIEWPORT_X; column++)
            {
                circle[row][column] = ' ';
            }
        }

        for(int i=0;  i < 360;  i++)
        {
            angle = Math.toRadians(i);//angle should be declared here. It's not used outside this code block
            x = (int)(r * Math.cos(angle)) + centerX;
            y = (int)(r * Math.sin(angle)) + centerY;

            if(x > -1 && y > -1 && x < VIEWPORT_X && y < VIEWPORT_Y)//x >= 0 looks better. 0 is usually not treated like a magic number
            {
                circle[y][x] = '+';
            }
        }

        circle[centerY][centerX] = 'X';

        for(row = 0; row < VIEWPORT_Y; row++)//bracket here -> try CTRL+L
        {
            for(column = 0; column < VIEWPORT_X; column++)
            {
                System.out.print(circle[row][column]);
            }
            System.out.println(" ");
        }
    }

}
