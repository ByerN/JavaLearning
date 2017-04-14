package org.byern.javalearning.lesson5.homework;

public class My_Exercise_1 {


    public static void main(String[] args) {

        int shift = 1;
        String slowo = "asia";
        String sentensAfterShiftValue = "";

        for (int i = 0; i < slowo.length(); i++) {

            char c2 = slowo.charAt(i);
            int acii2 = (int) c2;
            int indexWithShift = acii2 + shift;
            char z2 = (char) indexWithShift;
            sentensAfterShiftValue += String.valueOf(z2);

            System.out.println("index z przesunieciem " + indexWithShift);
            System.out.println("slowo po " + z2);
        }
        System.out.println("replae z przesunieciem KONIEC " + sentensAfterShiftValue);
    }

}
