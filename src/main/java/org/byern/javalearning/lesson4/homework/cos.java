package org.byern.javalearning.lesson4.homework;

/**
 * Created by Joasia Sitkowska on 2017-03-01.
 */
public class cos {

    public static void main(String[] args) {

        carpet(2);

    }

    public static boolean inCarpet(long x, long y) {
        while (x!=0 && y!=0) {
            if (x % 3 == 1 && y % 3 == 1)
                return false;
            x /= 3;
            y /= 3;
        }
        return true;
    }


    public static void carpet(final int iterationNumber) {
        final double power = Math.pow(3,iterationNumber);
        for(long i = 0; i < power; i++) {
            for(long j = 0; j < power; j++) {
                System.out.print(inCarpet(i, j) ? "*" : " ");
            }
            System.out.println();
        }
    }

}
