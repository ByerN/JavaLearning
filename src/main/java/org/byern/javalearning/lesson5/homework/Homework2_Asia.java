package org.byern.javalearning.lesson5.homework;

import java.util.Scanner;

/**
 * Created by ByerN on 02.03.2017.
 */
public class Homework2_Asia {

    public static void main(String[] args) {
        /* mozna uzyc regexow
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


        validateInput();

    }


    public static String[] validateInput() {
        String FIRST_NAME_WARMING = "First name is in incorrect format";
        String LAST_NAME_WARMING = "Last name is in incorrect format";
        String DATE_OF_BIRTH_WARNING = "Date of birth is in incorrect format";
        String WEIGHT_WARMING = "Weight is in incorrect format";
        String HEIGHT_WARMING = "Height is in incorrect format";

        String dateOfBirthPattern = "([0-9]{2})-([0-9]{2})-([0-9]{4})";
        String namePattern = "[a-zA-Z]+";

        String firstName;
        String lastName;
        String dateOfBirth;
        String weight;
        String height;

        boolean checkFirstName;
        boolean checkLastName;
        boolean checkDateOfBirth;
        boolean checkHeight = false;
        boolean checkWeight = false;

        String[] myArray = new String[5];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Provide the FIRST NAME: ");
        firstName = scanner.nextLine();

        while (firstName.isEmpty()) {
            System.out.println("Provide the FIRST NAME: ");
            firstName = scanner.nextLine();
        }


        System.out.println("Provide the LAST NAME: ");
        lastName = scanner.nextLine();

        while (lastName.isEmpty()) {
            System.out.println("Provide the LAST NAME: ");
            lastName = scanner.nextLine();
        }

        System.out.println("Provide the DATE OF BIRTH: ");
        dateOfBirth = scanner.nextLine();

        System.out.println("Provide the WEIGHT: ");
        weight = scanner.nextLine();

        System.out.println("Provide the HEIGHT: ");
        height = scanner.nextLine();


        checkFirstName = firstName.matches(namePattern);
        checkLastName = lastName.matches(namePattern);
        checkDateOfBirth = dateOfBirth.matches(dateOfBirthPattern);


        if (!checkFirstName) {
            System.out.println(myArray[0] = FIRST_NAME_WARMING);
        } else {
            myArray[0] = firstName;
        }

        if (!checkLastName) {
            System.out.println(myArray[1] = LAST_NAME_WARMING);

        } else {
            myArray[1] = lastName;
        }

//        -------------------------------------------------------
        if (!checkDateOfBirth) {
            System.out.println(myArray[2] = DATE_OF_BIRTH_WARNING);
        } else {
            myArray[2] = dateOfBirth;
        }


//        -------------------------------------------------------
        while (!checkWeight) {
            checkWeight = true;

            try {
                Float.parseFloat(weight);
                myArray[3] = weight;
            } catch (NumberFormatException e) {
                checkWeight = false;
                System.out.println(WEIGHT_WARMING);
                break;
            }
        }

        if (myArray[3] == null) {
            myArray[3] = "";
        }


//        -------------------------------------------------------
        while (!checkHeight) {
            checkHeight = true;

            try {
                Integer.parseInt(height);
                myArray[4] = height;
            } catch (NumberFormatException e) {
                checkHeight = false;
                System.out.println(HEIGHT_WARMING);
                break;
            }
        }

        if (myArray[4] == null) {
            myArray[4] = "";
        }

//        -------------------------------------------------------

        return myArray;
    }

}

