package org.byern.javalearning.lesson6.homework.solution;

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
        int oldLength = initialArray.length;
        int newLength = oldLength + 1;
        String[] result = new String[newLength];

        for (int n = 0; n < oldLength; n++) {
            result[n] = initialArray[n];
        }
        result[oldLength] = newElement;
        return result;
    }
}
