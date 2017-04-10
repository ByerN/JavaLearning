package org.byern.javalearning.lesson6.homework;

import static com.sun.org.apache.bcel.internal.classfile.Utility.printArray;

/**
 * Created by wojteks on 14/03/2017.
 */
public class Homework_1 {

    public static void main(String[] args) {

        String[] initialArray = {"1", "2", "3", "4"};
        String newElement = "5";
        String[] extendedArray;
        System.out.println("Orginal array");
        printArrayOnConsole(initialArray);
        extendedArray = addToArray(initialArray, newElement);
        System.out.println("Extended array");
        printArrayOnConsole(extendedArray);

    }

    private static void printArrayOnConsole(String[] initialArray) {
        for (int i =0; i< initialArray.length; i++){
            System.out.print(initialArray[i]+", ");
        }
        System.out.println();
    }

    private static String[] addToArray(String[] initialArray, String newElement) {

        String[] tempArray = new String[initialArray.length + 1];
        int i =0;
        for ( ; i < initialArray.length; i++) {
            tempArray[i] = initialArray[i];
        }
        tempArray[i] = newElement;
        return tempArray;
    }

// ctrl + alt + v
// ctrl+alt+m
// ctrl + alt + c
}
