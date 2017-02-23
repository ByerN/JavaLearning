package org.byern.javalearning.lesson2.homework;

import java.util.Scanner;
import java.lang.Math.*;

import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

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
        double x1, x2, y1, y2, r1, r2 = 0;
        System.out.println("x1,y1,r1,x2,y2,r2, next true/false");
        Scanner reader = new Scanner(System.in);

        x1 = reader.nextDouble();
        y1 = reader.nextDouble();
        x2 = reader.nextDouble();
        r1 = reader.nextDouble();
        y2 = reader.nextDouble();
        r2 = reader.nextDouble();

        //b = boolean;
        //b= reader.nextBoolean();

        double d; //distance between centers of circles
        double X,Y,R;
        X=x2-x1;
        Y=y2-y1;
        R=r2-r1;
        d=sqrt(pow(X,2)+pow(Y,2));


        if ((r1+r2)<=d)
        //if (pow(X,2)+pow(Y,2)<pow(R,2) AND )
            System.out.println("Collision detected");
        else
            System.out.println("Collision NOT detected");

    }

}
