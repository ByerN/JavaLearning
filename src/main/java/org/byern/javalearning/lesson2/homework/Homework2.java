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
     * rzutowanie na osie i true true
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter x1, y1 w1[width], h1[height]");
        System.out.print("x1");
        float x1 = Float.parseFloat(scanner.next());
        System.out.println();
        System.out.print("y1");
        float y1 = Float.parseFloat(scanner.next());
        System.out.println();
        System.out.print("w1");
        float w1 = Float.parseFloat(scanner.next());
        System.out.println();
        System.out.print("h1");
        float h1 = Float.parseFloat(scanner.next());

        System.out.println("Please enter x2, y2 w2[width], h2[height]");
        System.out.print("x2");
        float x2 = Float.parseFloat(scanner.next());
        System.out.println();
        System.out.print("y2");
        float y2 = Float.parseFloat(scanner.next());
        System.out.println();
        System.out.print("w2");
        float w2 = Float.parseFloat(scanner.next());
        System.out.println();
        System.out.print("h2");
        float h2 = Float.parseFloat(scanner.next());

        //       x1  <=   x2   <=   x1 + w1
        //      y1   <=    y2   <= y1+ h1

        if ((((x1<=x2)&&(x2 <= x1+w1)) && ((y1<=y2)&&(y2<=y1+h1)))
                                ||
                (((x2<=x1)&&(x1 <= x2+w2)) && ((y2<=y1)&&(y1<=y2+h2)))
                )
        {
            System.out.println("Colision detected!");
        }

        else
        {
            System.out.println("Colision not detected");
        }

    }

}
