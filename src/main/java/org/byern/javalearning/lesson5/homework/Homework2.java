package org.byern.javalearning.lesson5.homework;

/**
 * Created by ByerN on 02.03.2017.
 */
public class Homework2 {

    public static void main(String[] args) {
        /*
         * Validation:
         *
         * Create method:
         * public static String[] validateInput(
         *  String firstName,
         *  String lastName,
         *  String dateOfBirth,
         *  String weight,
         *  String height
         * )
         *
         * -Pass parameters from input.
         * -Validate each parameter according to following rules:
         *  -firstName and lastName should use only [a-zA-Z] characters ( cannot be empty )
         *  -dateOfBirth in format dd-MM-yyyy ( can be empty )
         *  -weight as floating point number ( can be empty )
         *  -height only integer ( can be empty )
         * -Program should COLLECT ALL violated constraints and return it in array.
         *
         * Example:
         *
         * String[] result = validateInput(
         *  "Chr is",
         *  "",
         *  "21-01-1991",
         *  "66-3",
         *  "170.90"
         * )
         *
         * result -> {
         *  "First name is in incorrect format",
         *  "Last name is in incorrect format",
         *  "Weight is in incorrect format",
         *  "Height is in incorrect format"
         * }//date is ok so it's not here
         *
         * *If everything is ok, return empty array.
         * *Array should be increased when new constraint is violated
         *  It can be achieved by simply copying old array values into new bigger one.
         * *Integer/Double/Date parsing methods could be helpful (it can be done by multiple different ways)
         * *Take a look at StringMethodsLesson
         * *Regex can be used too.
         */
    }
}
