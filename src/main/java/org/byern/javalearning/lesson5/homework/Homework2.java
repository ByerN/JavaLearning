package org.byern.javalearning.lesson5.homework;

import java.util.Scanner;

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

        String firstName, lastName, dateOfBirth, weight, height;

        Scanner scanner = new Scanner(System.in);
        System.out.println("First name");
        firstName = scanner.nextLine();
        System.out.println("Last name");
        lastName = scanner.nextLine();
        System.out.println("DOB:");
        dateOfBirth = scanner.nextLine();
        System.out.println("Weight");
        weight = scanner.nextLine();
        System.out.println("Height");
        height = scanner.nextLine();

        //to test String[] resultOfValidation = validateInput("", "p1n", "11-2/1999", "1,", "23.0");
        String[] resultOfValidation = validateInput(firstName, lastName, dateOfBirth, weight, height);
        showResults(resultOfValidation);


    }

    private static void showResults(String[] resultOfValidation) {
        for (int i = 0; i < resultOfValidation.length; i++) {
            System.out.println(resultOfValidation[i]);
        }
    }

    private static String[] validateInput(
            String firstName,
            String lastName,
            String dateOfBirth,
            String weight,
            String height
    ) {
        String[] resultTable = new String[0];

        try {

            if (!validateName(firstName)) {
                System.out.println("First name is in incorrect format");
                resultTable = increaseTabSize(resultTable, firstName);

            }
            ;
        } catch (NullPointerException e) {
            e.getStackTrace();
        }

        try {
            if (!validateName(lastName)) {
                System.out.println("Last name is in incorrect format");
                resultTable = increaseTabSize(resultTable, lastName);
                //result[1]=lastName;
            }
            ;
        } catch (NullPointerException e) {
            e.getStackTrace();
        }


        if (!validateDOB(dateOfBirth)) {
            System.out.println("DOB is in incorrect format");
            resultTable = increaseTabSize(resultTable, dateOfBirth);
            //result[2]=weight;
        }
        ;
        if (!validateWeight(weight)) {
            System.out.println("Weight is in incorrect format");
            resultTable = increaseTabSize(resultTable, weight);
            //result[3]=weight;
        }
        ;
        if (!validateHeight(height)) {
            System.out.println("Height is in incorrect format");
            resultTable = increaseTabSize(resultTable, height);
            //result[4]=weight;
        }
        ;


        return resultTable;
    }

    private static String[] increaseTabSize(String[] resultTable, String string) {

        String[] nowa = new String[resultTable.length + 1];
        System.arraycopy(resultTable, 0, nowa, 0, resultTable.length);
        nowa[resultTable.length] = string;
        resultTable = nowa;

        return resultTable;
    }

    private static boolean validateHeight(String height) {
        return (height.matches("[\\d]*"));
    }

    private static boolean validateDOB(String dateOfBirth) {

        if ((dateOfBirth.matches("[\\d]{1,2}[-][\\d]{1,2}[-][\\d]{4}")) || (dateOfBirth.isEmpty())) {
            return true;//[\d?\d{1}].[\d?\d{1}].[\d\d\d\d]
        }
        return false;
    }


    private static boolean validateWeight(String weight) {
        if ((weight.matches(("[\\d]+[,]?[\\d]+")) || weight.matches("[\\d]+[.]?[\\d]+"))) {
            return true;
        }
        return false;
    }


    private static boolean validateName(String bufor) {
        return ((bufor.matches("[a-zA-Z]*")));
    }
}
