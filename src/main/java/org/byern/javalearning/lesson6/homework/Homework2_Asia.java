package org.byern.javalearning.lesson6.homework;

import java.util.Scanner;

public class Homework2_Asia {

//    check if element is a palindrome

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide world: ");
        String element = scanner.nextLine();

        checkString(element);

    }

    public static boolean checkString(String element) {

        for (int counter = 0; counter < element.length(); counter++) {
            if (element.charAt(counter) != element.charAt(element.length() - 1 - counter)) {
                return false;
            }
        }

        return true;
    }

}
