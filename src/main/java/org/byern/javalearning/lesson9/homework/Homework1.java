package org.byern.javalearning.lesson9.homework;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by ByerN on 07.04.2017.
 */
public class Homework1 {
    private static final String FILE_IO = "plik.txt";

    /*
     * Polymorphic hello world.
     *
     * Make program that will say Hello world three ways:
     * -Simple System.out.println from method invocation
     * -Read from file and print
     * -Read from console and print
     *
     * Use template below and make it work.
     */

    public static void main(String[] args) {

//        HelloWorldService[] helloWorldServices = {/*Fill with implementation instances*/};
//        for(HelloWorldService helloWorldService : helloWorldServices){
//            helloWorldService.helloWorld();
//        }
        System.out.println("Hello world");

        try {
            System.out.println(Files.readAllLines(Paths.get("C:\\Users\\wojteks\\Documents\\javaKP\\JavaLearning\\src\\main\\java\\org\\byern\\javalearning\\lesson9\\homework\\plik.txt"), Charset.forName("UTF-8")).get(0).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Write your txt: ");
        Scanner scaner = new Scanner(System.in);
        System.out.println(scaner.nextLine());

    }

}
