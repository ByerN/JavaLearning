package org.byern.javalearning.lesson6.homework;


public class Homework1_Asia {

//    add element to the list

    public static void main(String[] args) {

        String[] exampleArray = new String[]{"a", "b", "c"};
        String exampleElement = "exampleElement";

//        exampleArray = addToArray(exampleArray, exampleElement);

        addToArray(exampleArray, exampleElement);

    }

    public static String[] addToArray(String[] initialArray, String newElement) {

        int lengthArray = initialArray.length;
        int n = ++lengthArray;

        String[] newArray = new String[n];

        for (int counter = 0; counter < initialArray.length; counter++) {
            newArray[counter] = initialArray[counter];
        }
        newArray[newArray.length -1 ] = newElement;
//        newArray[initialArray.length] = newElement;

        return newArray;
    }
}
