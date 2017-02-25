package org.byern.javalearning.lesson2.homework;

import java.util.Scanner;

/**
 * Created by ByerN on 21.02.2017.
 */
public class Homework1 {

    /*
     * There are two circles.
     *
     * Properties that describes circles are: x, y, r
     * x,y -> circle center coordinates
     * r -> circle radius
     *
     * 1. Read properties x1, y1, r1, x2, y2, r2 from input (Scanner usage)
     * 2. Store it in variables
     * 3a. If circles are colliding with each other (overlapping), print "Collision detected!"
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
     * -Math library can be useful. Check Math.sqrt(variable) documentation for example.
     * -https://en.wikipedia.org/wiki/Pythagorean_theorem
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Provide first circle center coordinates: ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        System.out.print("Provide first circle radius: ");
        int r1 = scanner.nextInt();

        System.out.print("Provide second circle center coordinates: ");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        System.out.print("Provide second circle radius: ");
        int r2 = scanner.nextInt();

        double d = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));

        if (d < r1 + r2) {
            System.out.println("Collision detected.");
        } else {
            System.out.println("Collision not detected.");
        }
    }

}