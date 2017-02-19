package org.byern.javalearning.lesson3;

/**
 * Created by ByerN on 19.02.2017.
 */
public class ArraysLoopsLesson {

    public static void main(String[] args){
        /*
         * Arrays are often combined with loops.
         */

        //For loop iteration through one dimensional array
        System.out.println("Array print (for loop):");
        String[] simpleArray = {"a","b","c","e","f","g","h","i","j","k"};

        for(int n=0; n< simpleArray.length; n++){
            System.out.println(simpleArray[n]);

        }
        System.out.println();
        System.out.println();

        //For each loop iteration through one dimensional array
        System.out.println("Array print (for loop):");
        String[] simpleArray2 = {"a","b","c","e","f","g","h","i","j","k"};

        for(String value: simpleArray2){
            System.out.println(value);

        }

        System.out.println();
        System.out.println();

        //For loop iteration through multidimensional array
        System.out.println("Multidimensional array print:");
        String[][] map = {
                {"x","x","x","x","x","x","x","x","x","x"},
                {"x","o","a","o","o","o","o","o","o","x"},
                {"x","o","o","o","o","o","o","o","o","x"},
                {"x","o","o","o","o","o","o","o","o","x"},
                {"x","o","o","o","o","o","o","o","o","x"},
                {"x","o","o","o","o","o","o","o","o","x"},
                {"x","o","o","o","o","o","o","o","o","x"},
                {"x","o","o","o","o","o","o","o","o","x"},
                {"x","o","o","o","o","o","o","o","o","x"},
                {"x","x","x","x","x","x","x","x","x","x"}
        };

        for(int y=0; y< map.length; y++){
            for(int x=0; x< map[y].length; x++){
                System.out.print(map[y][x]);
            }
            System.out.println();
        }
        /*Same with "for each" loop
        for (String[] row : map) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
        */
    }
}
