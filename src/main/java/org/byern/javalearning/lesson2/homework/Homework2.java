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

        System.out.println("Please provide 1st rectangle x value: ");
        int x1 = scanner.nextInt();
        System.out.println("Please provide 1st rectangle y value: ");
        int y1 = scanner.nextInt();
        System.out.println("Please provide 1st rectangle w value: ");
        int w1 = scanner.nextInt();
        System.out.println("Please provide 1st rectangle h value: ");
        int h1 = scanner.nextInt();
        System.out.println("Please provide 2nd rectangle x value: ");
        int x2 = scanner.nextInt();
        System.out.println("Please provide 2nd rectangle y value: ");
        int y2 = scanner.nextInt();
        System.out.println("Please provide 2nd rectangle w value: ");
        int w2 = scanner.nextInt();
        System.out.println("Please provide 2nd rectangle h value: ");
        int h2 = scanner.nextInt();
        System.out.println("Please provide if check should be inclusive (true) or exlusive (false)");
        boolean shouldBeInclusive = scanner.nextBoolean();

        boolean collision;
        boolean isIncluded;

        if (x2 + w2 < x1 || x2 > x1 + w1 || y2 > y1 + h1 || y2 + h2 < y1) {
            collision = false;
        } else {
            collision = true;
        }

        if (x2 > x1 && y2 > y1 && x2 + w2 < x1 + w1 && y2 + h2 < y1 + h1) {
            isIncluded = true;
        } else if (x1 > x2 && y1 > y2 && x1 < x2 + w2 && y1 < y2 + h2) {
            isIncluded = true;
        } else {
            isIncluded = false;
        }

        if(collision && shouldBeInclusive && isIncluded){
            System.out.println("Collision detected!");
        } else if (collision && !shouldBeInclusive && !isIncluded){
            System.out.println("Collision detected!");
        } else {
            System.out.println("Collision not detected!");
        }
    }

}
