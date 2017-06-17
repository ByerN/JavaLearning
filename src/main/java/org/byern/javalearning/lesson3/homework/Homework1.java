package org.byern.javalearning.lesson3.homework;

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


        String[] strzalka = {"  x  ", " xxx ", "xxxxx", " xxx ", " xxx ", " xxx ", " xxx ", " xxx ", " xxx ", "xxxxx"};

        for (int i = 0; i < 1000; i++) {
            for (int n = 0; n < 10; n++) {
                System.out.println(strzalka[n]);
            }
            Thread.sleep(300);
        }
        for (int n = 0; n < 40; n++) {
            if (n % 10 == 0) {
                System.out.println("   x   ");
            } else if (n % 10 == 1) {
                System.out.println("  xxx  ");
            } else if (n % 10 == 2) {
                System.out.println(" xxxxx ");
            } else if (n % 10 == 3) {
                System.out.println("  xxx  ");
            } else if (n % 10 == 4) {
                System.out.println("  xxx  ");
            } else if (n % 10 == 5) {
                System.out.println("  xxx  ");
            } else if (n % 10 == 6) {
                System.out.println("  xxx  ");
            } else if (n % 10 == 7) {
                System.out.println("  xxx  ");
            } else if (n % 10 == 8) {
                System.out.println("  xxx  ");
            } else if (n % 10 == 9) {
                System.out.println("  xxx  ");
            }

            Thread.sleep(300);
        }

    }

}

