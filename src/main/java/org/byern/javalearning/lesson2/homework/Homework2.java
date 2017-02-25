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
        Scanner scanner = new Scanner(System.in);

        System.out.print("Provide first rectangle left-bottom corner coordinates: ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        System.out.print("Provide first rectangle width and height: ");
        int w1 = scanner.nextInt();
        int h1 = scanner.nextInt();

        System.out.print("Provide second rectangle left-bottom corner coordinates: ");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        System.out.print("Provide second rectangle width and height: ");
        int w2 = scanner.nextInt();
        int h2 = scanner.nextInt();

        boolean collision = false;

        if( x2 <= x1 + w1 && x2 > x1 && y2 >= y1 && y2 <= y1 + w1 ) {
            collision = true;
        } else if( x2 <= x1 + w1 && x2 > x1 && y2 + w2 >= y1 && y2 + w2 <= y1 + w1 ) {
            collision = true;
        } else if( x2 + w2 <= x1 + w1 && x2 + w2 > x1 && y2 >= y1 && y2 <= y1 + w1 ) {
             collision = true;
        } else if( x2 + w2 <= x1 + w1 && x2 + w2 > x1 && y2 + w2 >= y1 && y2 + w2 <= y1 + w1 ) {
            collision = true;
        }

        if (collision) {
            System.out.println("Collision detected.");
        } else {
            System.out.println("Collision not detected.");
        }
    }

}
