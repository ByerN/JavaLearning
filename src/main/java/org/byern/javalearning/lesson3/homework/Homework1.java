package org.byern.javalearning.lesson3.homework;

import java.util.Scanner;

public class Homework1 {

    public static void main(String[] args) throws InterruptedException {
        /*
         * Replace if-else construction with looping through array.
         *
         * -play whole animation n-times -> n provided as input
         */
        String[] arrow = {
                "   x   ",
                "  xxx  ",
                " xxxxx ",
                "  xxx  ",
                "  xxx  ",
                "  xxx  ",
                "  xxx  ",
                "  xxx  ",
                "  xxx  ",
                "  xxx  "
        };

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many arrows should be printed: ");
        int howMany = scanner.nextInt();

        for (int n = 0; n < howMany; n++) {
            for (String line : arrow) {
                System.out.println(line);
                Thread.sleep(300);
            }
        }
    }

}
