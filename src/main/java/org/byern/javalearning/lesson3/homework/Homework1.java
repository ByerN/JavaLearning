package org.byern.javalearning.lesson3.homework;

import java.util.Scanner;

/**
 * Created by ByerN on 22.02.2017.
 */
public class Homework1 {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        String[] output = {"   x   ", "  xxx  ", " xxxxx ", "  xxx  ","  xxx  ",
                            "  xxx  ", "  xxx  ", "  xxx  ", "  xxx  ", "  xxx  "};

        System.out.println("Provide n");
        int n = scanner.nextInt();

        //play whole animation n-times -> not n frames
        for(int i = 0; i < n; i++){

            System.out.println(output[i % 10]);
            Thread.sleep(300);

        }

    }

}
