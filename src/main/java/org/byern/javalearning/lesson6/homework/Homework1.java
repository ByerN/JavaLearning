package org.byern.javalearning.lesson6.homework;

/**
 * Created by krzyspo on 14/03/2017.
 */
public class Homework1 {

    public static void main(String[] args) {
        /**
         * Create a method for adding an element to the array.
         */
        String[] testArray = {"Ala", "ma", "kota"};

        testArray = addToArray(testArray, "a");
        testArray = addToArray(testArray, "kot");
        testArray = addToArray(testArray, "ma");
        testArray = addToArray(testArray, "Ale");

        for (String item : testArray) {
            System.out.print(item + " ");
            /*
             * Expected result:
             * Ala ma kota a kot ma Ale
             */
        }
    }

    public static String[] addToArray(String[] initialArray, String newElement) {
        String[] result = null;
        return result;
    }
}
