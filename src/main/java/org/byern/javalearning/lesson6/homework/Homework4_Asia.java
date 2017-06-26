package org.byern.javalearning.lesson6.homework;


public class Homework4_Asia {

    public static void main(String[] args) {
        /*
         * Array cyclic shift (right).
         *
         * public static String[] shiftRight(String[] initialArray, int shiftValue);
         *
         * String[] result = shiftRight(new String[]{"a", "b", "c", "d"}, 2);
         * // {"c", "d", "a", "b"}
         *
         */

        int shiftValue = 2;
        String[] tab = {"a", "b", "c", "d"};
        shiftRight(tab, shiftValue);
    }


    public static void shiftRight(String[] initialArray, int shiftValue) {

        for (int i = 0; i < shiftValue; i++) {
            for (int j = initialArray.length - 1; j > 0; j--) {
                String position = initialArray[j];
                initialArray[j] = initialArray[j - 1];
                initialArray[j - 1] = position;
            }
        }

        for (int i = 0; i < initialArray.length; i++) {
            System.out.print(initialArray[i]);
        }

    }
}
