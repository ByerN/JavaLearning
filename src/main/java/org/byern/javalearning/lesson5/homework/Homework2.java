package org.byern.javalearning.lesson5.homework;

import com.sun.org.apache.xpath.internal.SourceTree;

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

        //to test      String[] resultOfValidation = validateInput("JAN ", "p1n","11-2/1999","1,","23.0");
        String[] resultOfValidation = validateInput(firstName, lastName, dateOfBirth, weight, height);
        show_resuls(resultOfValidation);


    }

    private static void show_resuls(String[] resultOfValidation) {
        for (int i = 0; i < resultOfValidation.length; i++) {
            System.out.println(resultOfValidation[i]);
        }
    }

    public static String[] validateInput(
            String firstName,
            String lastName,
            String dateOfBirth,
            String weight,
            String height
    ) {
        String[] result = new String[4];
        String[] result_by_adding = new String[0];

        if (!validate_name(firstName)) {
            System.out.println("First name is in incorrect format");
            // System.out.println(result_by_adding[0]);
            result_by_adding = increase_tab_size(result_by_adding, firstName);
            // System.out.println(result_by_adding[0]);
            // result[0]=firstName;
        }
        ;
        if (!validate_name(lastName)) {
            System.out.println("Last name is in incorrect format");
            result_by_adding = increase_tab_size(result_by_adding, lastName);
            //result[1]=lastName;
        }
        ;


        if (!validate_DOB(dateOfBirth)) {
            System.out.println("DOB is in incorrect format");
            result_by_adding = increase_tab_size(result_by_adding, dateOfBirth);
            //result[2]=weight;
        }
        ;
        if (!validate_weight(weight)) {
            System.out.println("Weight is in incorrect format");
            result_by_adding = increase_tab_size(result_by_adding, weight);
            //result[3]=weight;
        }
        ;
        if (!validate_height(height)) {
            System.out.println("Height is in incorrect format");
            result_by_adding = increase_tab_size(result_by_adding, height);
            //result[4]=weight;
        }
        ;


        return result_by_adding;
    }

    private static String[] increase_tab_size(String[] result_by_adding, String string) {

        String[] nowa = new String[result_by_adding.length + 1];
        System.arraycopy(result_by_adding, 0, nowa, 0, result_by_adding.length);
        nowa[result_by_adding.length] = string;
        result_by_adding = nowa;

        return result_by_adding;
    }

    private static boolean validate_height(String height) {
        if ((height.matches("[\\d]*"))) {
            return true;
        }
        return false;
    }

    private static boolean validate_DOB(String dateOfBirth) {

        if ((dateOfBirth.matches("[\\d]{1,2}[-][\\d]{1,2}[-][\\d]{4}")) || (dateOfBirth.isEmpty())) {
            return true;//[\d?\d{1}].[\d?\d{1}].[\d\d\d\d]
        }
        return false;
    }


    private static boolean validate_weight(String weight) {
        if ((weight.matches(("[\\d]+[,]?[\\d]+")) || weight.matches("[\\d]+[.]?[\\d]+")))
                 {
            return true;
        }
        return false;
    }


    private static boolean validate_name(String bufor) {
        if ((bufor.matches("[a-zA-Z]*"))) {
            return true;
        }
        return false;
    }
}
