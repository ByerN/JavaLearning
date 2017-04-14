package org.byern.javalearning.lesson4.homework;

public class Carpet {
    public static void main(String[] args) {
        /* dywan sierpinskiego
        //argumentem jest proces zagniezdzania
         * Make a method returning array representing Sierpinski carpet
         * and print it's result.
         *
         * boolean[][] createSierpinskiCarpet(int width, int height, int iterationNumber)
         *
         * width/height -> size o the returned array.
         * iterationNumber -> number of Sierpinski carpet iterations
         *
         * Assume that width and height is power of 3 - potega trojki
         *
         */

        int width = 2;
        int height = 2;
        int iterationNumber = 2;

        boolean[][] map = createSierpinskiCarpet(width, height, iterationNumber);

        for(int i = 0; i < width; i++){
            for(int j = 0; j< height; j++){
                System.out.println(map[i][j] ? "*" : " ");
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


    public  static boolean[][] createSierpinskiCarpet(int width, int height, int iterationNumber) {

        boolean[][] dywan = new boolean[height][width];


        int newWidth = width / 3;
        int newHeight = height / 3;

        inCarpet(width, height);

        if (iterationNumber > 1 && (height > 3 && width > 3)) {

            boolean[][] dywan2 = createSierpinskiCarpet(newHeight, newWidth, iterationNumber - 1);

            for (int a = 0; a < newHeight; a++) {
                for (int b = 0; b < newWidth; b++) {
                    dywan[a][b] = dywan2[a][b];
                }
            }
        }


        return dywan;

    }


    public static boolean inCarpet(int x, int y) {

        boolean[][] dywan = new boolean[x][y];

        for(int i = 0; i < dywan.length; i++){
            for(int j = 0; j < dywan[i].length; j++){

                while (x != 0 && y != 0) {
                    if (x % 3 == 1 && y % 3 == 1)
                        return false;
                    x /= 3;
                    y /= 3;
                }
                return true;
            }
        }
        return true;


    }

}





//    public static boolean inCarpet(long x, long y) {
//        while (x!=0 && y!=0) {
//            if (x % 3 == 1 && y % 3 == 1)
//                return false;
//            x /= 3;
//            y /= 3;
//        }
//        return true;
//    }
//
//    public static void carpet(final int n) {
//        final double power = Math.pow(3,n);
//        for(long i = 0; i < power; i++) {
//            for(long j = 0; j < power; j++) {
//                System.out.print(inCarpet(i, j) ? "*" : " ");
//            }
//            System.out.println();
//        }
//    }
