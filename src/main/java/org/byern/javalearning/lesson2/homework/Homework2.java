//package org.byern.javalearning.lesson2.homework;

/**
 * Created by ByerN on 21.02.2017.
 * Edited by Konrad
 */
 
import java.util.Scanner; 
import static java.lang.Math.*;
 
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
		double x1, y1, w1, h1, x2, y2, w2, h2;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Provide 1st rectangle's parameters");
		System.out.print("x1: ");
		x1 = input.nextInt();
		System.out.print("y1: ");
		y1 = input.nextInt();
		System.out.print("w1: ");
		w1 = input.nextInt();
		System.out.print("h1: ");
		h1 = input.nextInt();
		System.out.println("rectangle1: ("+x1+", "+y1+"), w1 = "+w1+", h1 = "+h1);
		System.out.println();
		
		System.out.println("Provide 2st rectangle's parameters");
		System.out.print("x2: ");
		x2 = input.nextInt();
		System.out.print("y2: ");
		y2 = input.nextInt();
		System.out.print("w2: ");
		w2 = input.nextInt();
		System.out.print("h2: ");
		h2 = input.nextInt();
		System.out.println("rectangle2: ("+x2+", "+y2+"), w2 = "+w2+", h2 = "+h2);
		System.out.println();
		
    }
}
