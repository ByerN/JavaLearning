package org.byern.javalearning.lesson2.homework;

//import java.util.Scanner;

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
     * odleglosc punktow suma promieni
     *
     */
    public static void main(String[] args) {

        float x1 = 0, y1 = 0, r1 = 0;
        float x2 = 0, y2 = 0, r2 = 0;


        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me data:");
        System.out.print("x1: ");
        x1 = Float.parseFloat(scanner.next());
        System.out.print("y1: ");
        y1 = Float.parseFloat(scanner.next());
        System.out.print("r1:");
        r1 = Float.parseFloat(scanner.next());

        System.out.println("Give me data:");
        System.out.print("x2: ");
        x2 = Float.parseFloat(scanner.next());
        System.out.print("y2: ");
        y2 = Float.parseFloat(scanner.next());
        System.out.print("r2:");
        r2 = Float.parseFloat(scanner.next());

        double distOfCircleCentres = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

        if (distOfCircleCentres < r1 + r2) {
            System.out.println("Colision detected");
        } else {
            System.out.println("Colision not detected");
        }
    }
}
