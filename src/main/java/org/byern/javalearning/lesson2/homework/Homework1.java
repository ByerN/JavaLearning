package org.byern.javalearning.lesson2.homework;

import java.util.Scanner;

public class Homework1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter x1");
        int x1 = scanner.nextInt();
        System.out.println("Enter y1");
        int y1 = scanner.nextInt();
        System.out.println("Enter x2");
        int x2 = scanner.nextInt();
        System.out.println("Enter y2");
        int y2 = scanner.nextInt();
        System.out.println("Enter r1");
        int r1 = scanner.nextInt();
        System.out.println("Enter r2");
        int r2 = scanner.nextInt();

        System.out.println("Check inclusive? (true/false)");
        boolean inclusive = scanner.nextBoolean();

        double distance = Math.sqrt( Math.pow(( x2-x1 ), 2 )  + Math.pow(( y2-y1 ), 2 ));

        if (inclusive ? distance <= (r1 + r2) : distance < (r1 + r2)) {
            System.out.println("Collision detected!");
        } else {
            System.out.println("Collision not detected!");
        }
    }

}
