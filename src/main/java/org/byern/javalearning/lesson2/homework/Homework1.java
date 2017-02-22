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

        System.out.println("Please enter first circle properties:");

        System.out.println("x1:");
        int x1 = scanner.nextInt();
        System.out.println("y1:");
        int y1 = scanner.nextInt();
        System.out.println("r1:");
        int r1 = scanner.nextInt();
        System.out.println("Please enter second circle properties:");

        System.out.println("x2:");
        int x2 = scanner.nextInt();
        System.out.println("y2:");
        int y2 = scanner.nextInt();
        System.out.println("r2:");
        int r2 = scanner.nextInt();

        System.out.println("Is collision inclusive?");
        boolean inclusive = scanner.nextBoolean();

        /*
         * Circle collision:
         *
         * c^2 = a^2 + b^2
         * c = sqrt ( a^2 + b^2 ) -> circles centers distance
         *
         * if c <= sum of circles radius -> collision
         * (< for exclusive)
         *
         */
        double c = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        if(inclusive ? c <= (r1 + r2) : c < (r1 + r2)){
            System.out.println("Collision detected!");
        } else {
            System.out.println("Collision not detected!");
        }

/*
        //Solution without floating point and sqrt -> better performance, lack of floating point
        //rounding issues.

        int cNoSqrt = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
        int rSqr = (r1 + r2) * (r1 + r2);
        if(inclusive ? cNoSqrt <= rSqr : cNoSqrt < rSqr){
            System.out.println("Collision detected!");
        } else {
            System.out.println("Collision not detected!");
        }
*/

/*      //Another attempt

        int cNoSqrt = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
        int rSqr = (r1 + r2) * (r1 + r2);
        if(cNoSqrt < rSqr || (inclusive && cNoSqrt == rSqr)){
            System.out.println("Collision detected!");
        } else {
            System.out.println("Collision not detected!");
        }
*/


    }

}
