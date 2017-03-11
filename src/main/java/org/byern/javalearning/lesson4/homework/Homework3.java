package org.byern.javalearning.lesson4.homework;

/**
 * Created by ByerN on 26.02.2017.
 */
public class Homework3 {

    static int INITIAL_SQUARE = 9;
    static boolean[][] carpet = new boolean[INITIAL_SQUARE][INITIAL_SQUARE];//true == black, false == white

    public static void main(String[] args) {
        /*
         * Make a method returning array representing Sierpinski carpet
         * and print it's result.
         *
         * boolean[][] createSierpinskiCarpet(int width, int height, int iterationNumber)
         *
         * width/height -> size o the returned array.
         * iterationNumber -> number of Sierpinski carpet iterations
         *
         * Assume that width and height is power of 3
         *
         */
        System.out.println("Podaj wielkosc:");

        initialize_carpet(INITIAL_SQUARE);
        make_carpet(INITIAL_SQUARE/3, INITIAL_SQUARE/3, INITIAL_SQUARE);
        draw_carpet(carpet);


    }
    //makin whole black (true)
    private static void initialize_carpet(int initialSquare) {
        for (int i = 0; i < initialSquare; i++) {
            for (int j = 0; j < initialSquare; j++) {
                carpet[i][j] = true;

            }
        }
        System.out.println("Table initialized");
    }



    private static void make_carpet(int x_0, int y_0, int initialSquare) {
        int len = initialSquare/3;

        x_0 = len;
        y_0 = len;

        int x_1 = 2*len;   //we whiten only the middle square
        int y_1 = 2*len ;

        //whitening the middle square
        for (int i = x_0; i < x_1; i++) {
            for (int j = y_0; j < y_1; j++) {
                carpet[i][j] = false;
            }
        }

        if (initialSquare > 3) {
            initialSquare /= 3;
            make_carpet(0,                  0,  initialSquare);
            make_carpet(1*initialSquare,    0,  initialSquare);
            make_carpet(2*initialSquare,    0,  initialSquare);

            make_carpet(0,                  initialSquare, initialSquare);
            make_carpet(2*initialSquare,    initialSquare, initialSquare);

            make_carpet(0,                  2*initialSquare, initialSquare);
            make_carpet(1*initialSquare,    2*initialSquare, initialSquare);
            make_carpet(2*initialSquare,    2*initialSquare, initialSquare);
        }
    }



    private static void draw_carpet(boolean[][] carpet) {
        for (int i = 0; i < INITIAL_SQUARE; i++) {
            for (int j = 0; j < INITIAL_SQUARE; j++) {
                if (carpet[i][j] == true) {
                    System.out.print("x");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();//new line
        }
    }
}
