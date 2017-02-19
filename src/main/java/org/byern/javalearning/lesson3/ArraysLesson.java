package org.byern.javalearning.lesson3;

/**
 * Created by ByerN on 19.02.2017.
 */
public class ArraysLesson {

    public static int n = 0;

    public static void main(String[] args) {
        /*
         * "An array is a container object that holds a fixed number of values of a single type.
         * The length of an array is established when the array is created. After creation, its length is fixed."
         * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html
         *
         * Usage:
         *
         * Array declaration:
         * int[] arrayName;
         * int arrayName[]; //This one is considered as a bad practice -> data type looks like "int" but it's an "int[]"
         *
         * Caution! Default array value is "null".
         *
         * Array initialization:
         * int[] arrayName = new int[10]; //allocates memory for 10 "int" values
         * int[] arrayName = new int[]{1, 2, 3, 4}; //creates int array with 4 length and initializes values
         * int[] arrayName = {1, 2, 3, 4}; //another form of array initialization
         *
         * Get/Set array value:
         *
         * arrayName[0] = 2;
         * System.out.println(arrayName[0]); // prints 2
         *
         * Caution! Important and hard to understand thing is that arrays/collections indices are starting from 0.
         *
         */

        int[] arrayName;
        //arrayName[1] =2; // compilation error -> not initialized

        /*
            Array length = 3
            --------------------------
            Indices     0   1   2
            Values      cat dog turtle
         */
        String[] animalsArray = {"cat", "dog", "turtle"};

        System.out.println();
        System.out.println("Array example 1:");
        System.out.println(animalsArray); //prints "[Ljava.lang.String;@756095fc"-> 756095fc -> hashed reference

        System.out.println(animalsArray[0]);// cat
        System.out.println(animalsArray[1]);// dog
        System.out.println(animalsArray[2]);// turtle

        System.out.println();
        System.out.println("Array example 2 (after array values update):");
        animalsArray[0] = animalsArray[1] = animalsArray[2] = "Nothing";
        System.out.println(animalsArray);

        System.out.println(animalsArray[0]);// Nothing
        System.out.println(animalsArray[1]);// Nothing
        System.out.println(animalsArray[2]);// Nothing

        /*
         * If you try to get array element that is out of bound, you will get an error (runtime exception).
         * It will not be found on the compilation level!
         */
        //System.out.println(animalsArray[3]);// Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3

        /*
         * You can simply get a length of array by using length method
         */
        System.out.println();
        System.out.println("Array length test:");
        int[] numbers = {1, 2, 3, 4};
        System.out.println("Array length: " + numbers.length); //prints "4"

        /*
         * Multidimensional arrays:
         *
         * int[][] multidimensionalArray = {{11, 121}, {12, 22, 32}};
         */

        System.out.println();
        System.out.println("Multidimensional array test:");

        String[][] multidimensionalArray = {
                {"a1", "a2"},
                {"b1", "b2", "b3"}
        };
        System.out.println(multidimensionalArray[0][0]); //"a1"
        System.out.println(multidimensionalArray[1][2]); //"b3"

    }
}
