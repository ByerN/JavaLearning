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
        int n;
        //Too long line
        String[] x = {"   x   ", "  xxx  ", " xxxxx ", "  xxx  ", "  xxx  ", "  xxx  ", "  xxx  ", "  xxx  ", "  xxx  ", "  xxx  "};

        System.out.print("n = ");
        n = scanner.nextInt();

        //play whole animation n-times -> not n frames
        for (int i = 0; i < n; i++) {
            System.out.println(x[i % 10]);//10 -> not scaling -> better use array length
            Thread.sleep(300);
        }
    }
}
