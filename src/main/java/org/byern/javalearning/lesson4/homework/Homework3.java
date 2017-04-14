package org.byern.javalearning.lesson4.homework;

/**
 * Created by ByerN on 26.02.2017.
 */
public class Homework3 {

    public static void main(String[] args) {
        /* dywan sierpinskiego
        //argumentm jest proces zagniezdzania
         * Make a method returning array representing Sierpinski carpet
         * and print it's result.
         *
         * boolean[][] createSierpinskiCarpet(int width, int height, int iterationNumber)
         *
         * width/height -> size o the returned array.
         * iterationNumber -> number of Sierpinski carpet iterations
         *
         * Assume that width and height is power of 3 - potega trojki
         *wydrukowac na ekran
         */
        int width = 27;
        int height = 27;
        int iterationNumber = 5;

        boolean[][] map = createSierpinskiCarpet(width, height, iterationNumber);

        for(int i = 0; i < height; i++){
            for(int j = 0; j< width; j++){
                System.out.println(map[i][j] ? " " : "*");
            }
            System.out.println();
        }


//        final double power = Math.pow(3,iterationNumber);
//        for(int i = 0; i < power; i++) {
//            for(int j = 0; j < power; j++) {
//                System.out.print(map[i][j] ? "*" : " ");
//            }
//            System.out.println();
//        }

    }


    public static boolean[][] createSierpinskiCarpet(int width, int height, int iterationNumber){

        int newHeight = height/3;
        int newWidth = width/3;

        boolean dywan[][] = new boolean[height][width];


        if(iterationNumber > 1 && width > 3 && height > 3){

            boolean[][] dywan2 = createSierpinskiCarpet(newWidth, newHeight, iterationNumber - 1);

            for(int a = 0; a < height; a ++){
                for (int b = 0; b < width; b++){
                    dywan[a][b] = dywan2[a%newHeight][b%newWidth];
                }
            }

        }

        for(int row = newHeight; row < newHeight*2; row++) {
                        for (int column = newWidth; column < newWidth*2; column++) {
                                dywan[row][column] = true;
                            }
                    }


    return dywan;
    }
}
