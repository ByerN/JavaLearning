package org.byern.javalearning.lesson6.homework;

public class Homework3_Asia {

    public static void main(String[] args) {
        /*
         * Reverse an array.
         *
         * public static String[] reverse(String[] initialArray);
         *
         * String[] result = reverse(new String[]{"a", "b", "c"});
         * // {"c", "b", "a"}
         *
         */

        String[] tab = {"a", "b", "c", "d"};
        reverse(tab);

    }


    public static String[] reverse(String[] initialArray) {

        for (int i = 0; i < initialArray.length / 2; i++) {
            String position = initialArray[i];
            initialArray[i] = initialArray[initialArray.length - 1 - i];
            initialArray[initialArray.length - 1 - i] = position;
        }

        for (int x=0; x < initialArray.length; x++) {
            System.out.print(initialArray[x]);
        }

        return initialArray;
    }
}
