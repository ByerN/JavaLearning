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
        System.out.println("Please provide 1st circle x value: ");
        int x1 = scanner.nextInt();
        System.out.println("Please provide 1st circle y value: ");
        int y1 = scanner.nextInt();
        System.out.println("Please provide 1st circle r value: ");
        int r1 = scanner.nextInt();
        System.out.println("Please provide 2nd circle x value: ");
        int x2 = scanner.nextInt();
        System.out.println("Please provide 2nd circle y value: ");
        int y2 = scanner.nextInt();
        System.out.println("Please provide 2nd circle r value: ");
        int r2 = scanner.nextInt();
        System.out.println("Please provide if check should be inclusive (true) or exlusive (false)");
        boolean inclusive = scanner.nextBoolean();

        boolean collision = false;

        double xDiff = x1 - x2;
        double yDiff = y1 - y2;
        double distance = Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));


        if (r1 + r2 >= distance) {
            if (Math.min(r1, r2) + distance <= Math.max(r1, r2)) {
                if (inclusive) {
                    collision = true;
                }
            } else {
                if (!inclusive) {
                    collision = true;
                }
            }
        }

        if (collision){
            System.out.println("Collision detected.");
        } else {
            System.out.println("Collision not detected.");
        }
    }

}