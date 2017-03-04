package org.byern.javalearning.lesson2.homework;

import java.util.Scanner;

/**
 * Created by ByerN on 21.02.2017.
 */
public class Homework2 {

    /*
     * There are two rectangles.
     *
     * Properties that describes rectangles are: x, y, w, h
     * x,y -> rectangle left-bottom corner coordinates
     * w -> width
     * h -> height
     *
     *
     * 1. Read properties x1, y1, w1, h1, x2, y2, w2, h2 from input (Scanner usage)
     * 2. Store it in variables
     * 3a. If rectangles are colliding with each other (overlapping), print "Collision detected!"
     * 3b. else -> print "Collision not detected!"
     *
     * If the smaller one is in the bigger one it's still collision.
     * Inclusive collision.
     *
     * Advanced:
     * -Read a boolean flag from input that says if collision check is inclusive or exclusive
     *  and use it in collision calculation (true -> inclusive, false -> exclusive)
     *
     * Hint:
     * -https://en.wikipedia.org/wiki/De_Morgan%27s_laws
     * 
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //Creates input to our program

        System.out.println("Enter details of the 1st rectangle (left bottom corner coordinates, width, height)");

        System.out.print("Left bottom corner X1 = ");
        float x1 = scanner.nextFloat();

        System.out.print("Left bottom corner Y1 = ");
        float y1 = scanner.nextFloat();

        System.out.print("Width 1 = ");
        float width1 = scanner.nextFloat();

        System.out.print("Height 1 = ");
        float height1 = scanner.nextFloat();

        System.out.println();

        System.out.println("Enter details of the 2nd rectangle (left bottom corner coordinates, width, height)");

        System.out.print("Left bottom corner X2 = ");
        float x2 = scanner.nextFloat();

        System.out.print("Left bottom corner Y2 = ");
        float y2 = scanner.nextFloat();

        System.out.print("Width 2 = ");
        float width2 = scanner.nextFloat();

        System.out.print("Height 2 = ");
        float height2 = scanner.nextFloat();

        System.out.println();

        System.out.println("Result:");
        System.out.print("The two rectangles collide: " + collisionDetection(x1, y1, width1, height1, x2, y2, width2, height2));
    }

    public static boolean collisionDetection (float x1, float y1, float w1, float h1, float x2, float y2, float w2, float h2){

        if(x1+w1<x2 || x2+w2 < x1 || y1+h1 < y2 || y2+h2 < y1) {
            return false;
        } else {
            return true;
        }
    }

}
