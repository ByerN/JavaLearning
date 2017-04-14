package org.byern.javalearning.lesson3.homework;

import java.util.Scanner;


public class Homework1_Asia {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide the number of repetitions: ");
        int x = scanner.nextInt();

        int counter = 0;
        do {
            arrayImage();
            counter++;
        } while (counter < x);


    }

    public static void arrayImage()throws InterruptedException{
        String[][] map = {
                {"  ", "  ", " x", "  ", "  "},
                {"  ", " x", " x", " x", "  "},
                {" x", " x", " x", " x", " x"},
                {"  ", " x", " x", " x", "  "},
                {"  ", " x", " x", " x", "  "},
                {"  ", " x", " x", " x", "  "},
                {"  ", " x", " x", " x", "  "},
                {"  ", " x", " x", " x", "  "},
                {"  ", " x", " x", " x", "  "},
                {"  ", " x", " x", " x", "  "},
        };

        for(int y=0; y< map.length; y++){
            for(int x=0; x< map[y].length; x++){
                System.out.print(map[y][x]);
            }
            System.out.println();
            Thread.sleep(300);
        }
    }

}
