package org.byern.javalearning.lesson6.homework.solution;

/**
 * Created by krzyspo on 14/03/2017.
 */
public class Homework2 {


    public static void main(String[] args) {
        /**
         * Create a method for checking if provided
         * String is a palindrome.
         *
         * public static boolean isPalindrome(String value)
         * //returns true if value is a palindrome
         *
         * Palindrome:
         * ala
         * alla
         * alalala
         * AlalalA
         *
         * * case-sensitive
         */
    }

    public static boolean isPalindrome(String value) {
        for (int n = 0; n < value.length() / 2; n++) {
            if (value.charAt(n) != value.charAt(value.length() - 1 - n)) {
                return false;
            }
        }
        return true;
    }
}
