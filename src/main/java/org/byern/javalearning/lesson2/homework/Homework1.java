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

        System.out.println("Enter coordinates and radius of the 1st circle");

        System.out.print("X1 = ");
        float x1 = scanner.nextFloat();

        System.out.print("Y1 = ");
        float y1 = scanner.nextFloat();

        System.out.print("R1 = ");
        float r1 = scanner.nextFloat();

        System.out.println();
        System.out.println("Enter coordinates and radius of the 2nd circle");

        System.out.print("X2 = ");
        float x2 = scanner.nextFloat();

        System.out.print("Y2 = ");
        float y2 = scanner.nextFloat();

        System.out.print("R2 = ");
        float r2 = scanner.nextFloat();

        System.out.print("Inclusive Collision? true/false: ");
        boolean inclusion = scanner.nextBoolean();

        System.out.println("Result:");
        System.out.print(collisionDetection(x1, y1, r1, x2, y2, r2, inclusion));
    }

    public static boolean collisionDetection (float x1, float y1, float r1, float x2, float y2, float r2, boolean inclusionCollisionMatters){

        double r1r2Distance = Math.sqrt(Math.pow(x2-x1,2)+ Math.pow(y2-y1,2));

        if (r1r2Distance > r1+r1) {
            return false;
        } else if (r1r2Distance == r1+r2) {
            return true;
        } else if ((r1r2Distance < r1+r2) && (r1r2Distance > Math.abs(r1-r2))){
            return true;
        } else if ((r1r2Distance <= Math.abs(r1-r2)) && (inclusionCollisionMatters)){
            return true;
        } else {
            return false;
        }

    }

}
