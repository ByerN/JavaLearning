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

        for(int n=0; n< 40; n++){
            if(n % 10 == 0){
                System.out.println("   x   ");
            } else if(n % 10 == 1){
                System.out.println("  xxx  ");
            } else if(n % 10 == 2){
                System.out.println(" xxxxx ");
            } else if(n % 10 == 3){
                System.out.println("  xxx  ");
            } else if(n % 10 == 4){
                System.out.println("  xxx  ");
            } else if(n % 10 == 5){
                System.out.println("  xxx  ");
            } else if(n % 10 == 6){
                System.out.println("  xxx  ");
            } else if(n % 10 == 7){
                System.out.println("  xxx  ");
            } else if(n % 10 == 8){
                System.out.println("  xxx  ");
            } else if(n % 10 == 9){
                System.out.println("  xxx  ");
            }

            Thread.sleep(300);

        }
*/

        String a = "  xxx  ";
        String[] arrName = {"   x   ", "  xxx  ", " xxxxx ", a, a, a, a, a, a, a};

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many times array should be displayed?");
        int times = Integer.parseInt(scanner.next());

        {
            for (int n = 0; n < times; n++) {
                for (int i = 0; i < arrName.length; i++) {
                    System.out.println(arrName[i]);
                    Thread.sleep(250);
                }
            }

        }

    }
}