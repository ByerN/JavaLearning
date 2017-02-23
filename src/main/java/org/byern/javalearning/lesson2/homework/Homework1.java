package org.byern.javalearning.lesson2.homework;

import java.util.Scanner;
import java.math.*;

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

        System.out.println("Provide 1st circle center coordinates.\nType X1 value: ");
        double x1 = scanner.nextDouble();
        System.out.println("Type Y1 value: ");
        double y1 = scanner.nextDouble();
        System.out.println("Provide 1st circle radius.\nType R1 value: ");
        double r1 = scanner.nextDouble();

        System.out.println("Provide 2nd circle center coordinates.\nType X2 value: ");
        double x2 = scanner.nextDouble();
        System.out.println("Type Y2 value: ");
        double y2 = scanner.nextDouble();
        System.out.println("Provide 2nd circle radius.\nType R2 value: ");
        double r2 = scanner.nextDouble();

        double centDist = Math.sqrt(Math.pow( (x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double radSum = r1 + r2;
        double radDiffAbs = Math.abs( r1 - r2);

        System.out.println("1st CIRCLE\n" +
                "Coordinates: " + x1 + " : " + y1 + "\n" +
                "Radius: " + r1 + "\n");
        System.out.println("2nd CIRCLE\n" +
                "Coordinates: " + x2 + " : " + y2 + "\n" +
                "Radius: " + r2 + "\n");

        if ( x1 == x2 && y1 == y2){
            if (r1 == r2){
                System.out.println("Circles have same center AND overlapping!");
            }
            else if (r1 < r2){
                System.out.println("Circles have same center AND 1st circle is inside 2nd.");
            }
            else if (r1 > r2){
                System.out.println("Circles have same center AND 2nd circle is inside 1st.");
            }
        }
        else if (x1 != x2 || y1 != y2){
            if (centDist > radSum){
                System.out.println("Circles are disjoint externally.");
            }
            else if (centDist == radSum){
                System.out.println("Circles externally tangent.");
            }
            else if (centDist < radSum){
                if (centDist == radDiffAbs){
                    System.out.println("Circles internally tangent.");
                }
                else if (centDist < radDiffAbs){
                    System.out.println("Circles are disjoint internally.");
                }
                else if (centDist > radDiffAbs){
                    if (r1 == r2 && r1 == centDist){
                        System.out.println("Circles intersect!\n" +
                                "1st circle center is located on the circumference of the 2nd circle.\n" +
                                "2nd circle center is located on the circumference of the 1st circle.");
                    }
                    if (centDist == r1 && r1 > r2){
                        System.out.println("Circles intersect!\n" +
                                "2nd circle center is located on the circumference of the 1st circle.");
                    }
                    if (centDist == r2 && r2 > r1){
                        System.out.println("Circles intersect!\n" +
                                "1st circle center is located on the circumference of the 2nd circle.");
                    }
                    else if (centDist > r1 && centDist > r2){
                        System.out.println("Circles intersect externally!");
                    }
                    else if (centDist <= r1 && centDist <= r2){
                        System.out.println("Circles intersect internally!");
                    }
                    else
                        System.out.println("Something is terribly wrong!?!");
                }
            }
        }
    }
}
