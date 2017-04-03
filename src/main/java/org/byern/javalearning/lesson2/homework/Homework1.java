package org.byern.javalearning.lesson2.homework;

/**
 * Created by ByerN on 21.02.2017.
 * Edited by Konrad
 */
 
import java.util.Scanner; 
import static java.lang.Math.*;
 
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
		double x1, y1, r1, x2, y2, r2;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Provide 1st circle's coordinates and radius");
		System.out.print("x1: ");
		x1 = input.nextInt();
		System.out.print("y1: ");
		y1 = input.nextInt();
		System.out.print("r1: ");
		r1 = input.nextInt();
		System.out.println("circle1: ("+x1+", "+y1+"), r1 = "+r1);
		System.out.println();
		
		System.out.println("Provide 2nd circle's coordinates and radius");
		System.out.print("x2: ");
		x2 = input.nextInt();
		System.out.print("y2: ");
		y2 = input.nextInt();
		System.out.print("r2: ");
		r2 = input.nextInt();
		System.out.println("circle2: ("+x2+", "+y2+"), r2 = "+r2);
		System.out.println();
		
		double distance = sqrt(pow(abs(x2-x1),2)+pow(abs(y2-y1),2));
		double sumR1R2 = r1+r2;

		if (distance<=sumR1R2) {
			System.out.print("Collision detected! ");
			if ((r1>=r2 && (distance+r2)<=r1) || (r2>=r1 && (distance+r1)<=r2)) {
				System.out.println("Collision is inclusive!");
			} else {
				System.out.println("Collision is exclusive!");
			}
		} else {
			System.out.println("Collision not detected!");
		}

    }
}
