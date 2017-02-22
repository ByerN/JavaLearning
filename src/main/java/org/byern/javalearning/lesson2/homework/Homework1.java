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
        Scanner scanner = new Scanner(System.in); //Creates input to our program
        System.out.println("Enter x1");
        int x1 = scanner.nextInt();
        System.out.println("Enter y1");
        int y1 = scanner.nextInt();
        System.out.println("Enter r1");
        int r1 = scanner.nextInt();

        System.out.println("Enter x2");
        int x2 = scanner.nextInt();
        System.out.println("Enter y2");
        int y2 = scanner.nextInt();
        System.out.println("Enter r2");
        int r2 = scanner.nextInt();
        //System.out.println("x1=" + x1 + "; y1=" + y1 + "; r1=" + r1);
        double checker = Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2));
        //System.out.println(checker);
        if ((r1+r2)>=checker){System.out.println("Collision detected!");}
        else {System.out.println("Collision not detected!");}



        /*add boolean for check Collision
        boolean b = false;
        do {
            try {
                System.out.print("Are you above 18?");
                Scanner n = new Scanner(System.in);
                boolean bn = n.nextBoolean();
                if (bn == true) {
                    System.out.println("Over 18");
                } else if (bn == false) {
                    System.out.println("under 18");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
            }
        } while (!b);
        */

    }
}