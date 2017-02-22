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

        System.out.println("Please enter first rectangle properties:");

        System.out.println("x1:");
        int x1 = scanner.nextInt();
        System.out.println("y1:");
        int y1 = scanner.nextInt();
        System.out.println("w1:");
        int w1 = scanner.nextInt();
        System.out.println("h1:");
        int h1 = scanner.nextInt();

        System.out.println("Please enter second rectangle properties:");

        System.out.println("x2:");
        int x2 = scanner.nextInt();
        System.out.println("y2:");
        int y2 = scanner.nextInt();
        System.out.println("w2:");
        int w2 = scanner.nextInt();
        System.out.println("h2:");
        int h2 = scanner.nextInt();

        System.out.println("Is collision inclusive?");
        boolean inclusive = scanner.nextBoolean();

        if (inclusive && !(x1 + w1 < x2 ||
                x1 > x2 + w2 ||
                y1 + h1 < y2 ||
                y1 > y2 + h2)) {
            System.out.println("Collision detected!");
        } else if (!inclusive && !(x1 + w1 <= x2 ||
                x1 >= x2 + w2 ||
                y1 + h1 <= y2 ||
                y1 >= y2 + h2)) {
            System.out.println("Collision detected!");
        } else {
            System.out.println("Collision not detected!");
        }

        /* Other solution examples:
        1.
        if ((inclusive &&
                !(x1 + w1 < x2 ||
                x1 > x2 + w2 ||
                y1 + h1 < y2 ||
                y1 > y2 + h2)) ||
            (!inclusive &&
                !(x1 + w1 <= x2 ||
                x1 >= x2 + w2 ||
                y1 + h1 <= y2 ||
                y1 >= y2 + h2))) {
            System.out.println("Collision detected!");
        } else {
            System.out.println("Collision not detected!");
        }

        2.
        if (inclusive ?
                !(x1 + w1 < x2 ||
                x1 > x2 + w2 ||
                y1 + h1 < y2 ||
                y1 > y2 + h2)
                :
                !(x1 + w1 <= x2 ||
                x1 >= x2 + w2 ||
                y1 + h1 <= y2 ||
                y1 >= y2 + h2)) {
            System.out.println("Collision detected!");
        } else {
            System.out.println("Collision not detected!");
        }

        3.
        if (inclusive ?
                (x1 <= x2 + w2 &&
                x1 + w1 >= x2 &&
                y1 <= y2 + h2 &&
                h1 + y1 >= y2)
                :
                (x1 < x2 + w2 &&
                x1 + w1 > x2 &&
                y1 < y2 + h2 &&
                h1 + y1 > y2)
                ) {
            System.out.println("Collision detected!");
        } else {
            System.out.println("Collision not detected!");
        }

        */
    }

}
