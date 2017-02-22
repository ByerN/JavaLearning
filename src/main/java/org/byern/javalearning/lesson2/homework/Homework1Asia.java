package org.byern.javalearning.lesson2.homework;

import java.util.Scanner;

/**
 * Created by ByerN on 21.02.2017.
 */
public class Homework1Asia {

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

    public static double x1;
    public static double y1;
    public static double r1;
    public static double x2;
    public static double y2;
    public static double r2;
    public static String question;
    public static boolean setFlag;
    public static double distance;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        setDataForCircle();
        setFlag();
        calculateDistanceBetweenTwoCircles();
        checkConditions();

    }

    public static void setDataForCircle() {

        System.out.println("Provide x1:");
        x1 = scanner.nextInt();

        System.out.println("Provide y1:");
        y1 = scanner.nextDouble();

        System.out.println("Provide r1:");
        r1 = scanner.nextDouble();

        System.out.println("Provide x2:");
        x2 = scanner.nextDouble();

        System.out.println("Provide y2:");
        y2 = scanner.nextDouble();

        System.out.println("Provide r2:");
        r2 = scanner.nextDouble();

        System.out.println("Data for the first circle: " + "\n" + "circle center: " + "(" + x1 + ", " + y1 + ")" + " and circle radius: " + r1);
        System.out.println("Data for the first circle: " + "\n" + "circle center: " + "(" + x2 + ", " + y2 + ")" + " and circle radius: " + r2);

        System.out.println("\n" + "Would you like that the smaller one will be in the bigger one it's still collision: yes OR not?");
        question = scanner.next();

        while (!(question.equals("yes") || question.equals("not"))) {
            System.out.println("Please provide yes or not!");
            question = scanner.next();
        }

    }

    public static boolean setFlag() {
        if (question.equals("yes")) {
            setFlag = true;
        } else setFlag = false;
        return setFlag;
    }

    public static void calculateDistanceBetweenTwoCircles() {
        distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        System.out.println("\n" + "Calculate the distance between two circles: " + (int) distance);
    }

    public static void checkConditions() {
        if (setFlag) {
            if (distance > (r1 + r2)) {
                System.out.println("\n" + "Collision not detected!");
            } else if (distance == (r1 + r2)) {
                System.out.println("\n" + "Collision detected!");
            } else if (distance > Math.abs(r1 - r2) && distance < (r1 + r2)) {
                System.out.println("\n" + "Collision detected!");
            } else if (distance == Math.abs(r1 - r2)) {
                System.out.println("\n" + "Collision detected!");
            } else if (distance < Math.abs(r1 - r2)) {
                System.out.println("\n" + "Collision detected!");
            }
        } else {
            if (distance > (r1 + r2)) {
                System.out.println("\n" + "Collision not detected!");
            } else if (distance == (r1 + r2)) {
                System.out.println("\n" + "Collision detected!");
            } else if (distance > Math.abs(r1 - r2) && distance < (r1 + r2)) {
                System.out.println("\n" + "Collision detected!");
            } else if (distance == Math.abs(r1 - r2)) {
                System.out.println("\n" + "Collision not detected!");
            } else if (distance < Math.abs(r1 - r2)) {
                System.out.println("\n" + "Collision not detected!");
            }
        }
    }

}
