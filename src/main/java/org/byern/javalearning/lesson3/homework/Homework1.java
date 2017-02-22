package org.byern.javalearning.lesson3.homework;

import java.util.Scanner;

/**
 * Created by ByerN on 22.02.2017.
 */
public class Homework1 {

    public static void main(String[] args) throws InterruptedException {
        /*
         * Replace if-else construction with looping through array.
         *
         * -play whole animation n-times -> n provided as input
         */
        Scanner scanner = new Scanner(System.in);
        int iterationsNumber = scanner.nextInt();

        String[] frames = new String[]{
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
        for(int n = 0; n< iterationsNumber * frames.length; n++){
            System.out.println(frames[n % frames.length]);
            Thread.sleep(300);
        }

    }

}
