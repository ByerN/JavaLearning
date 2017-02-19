package org.byern.javalearning.lesson3;

/**
 * Created by ByerN on 19.02.2017.
 */
public class LoopBranchingLesson {

    public static void main(String[] args) {

        /*
         * There are few statements that can be used for branching.
         * Loop specific statements are "break" and "continue".
         *
         * "break" statement is used to get out of the loop.
         */
        System.out.println("Break example1: ");
        while (true) { // this loop looks like infinite one but it's ok
            System.out.println("Inside the loop.");
            break; //it moves program out from the loop
            //System.out.println("Unreachable statement"); // compilation error: Unreachable statement
        }
        //here we are after break.

        System.out.println("Break example2: ");
        int waterInTheBucket = 50;
        int iterationCount = 0;
        for (int n = 0; ; n++) {
            waterInTheBucket -= n;
            iterationCount++;
            if (waterInTheBucket <= 0) {
                System.out.println("There is no more water in the bucket.");
                break;
            }
            System.out.println("There is a " + waterInTheBucket + " l in the bucket");
        }
        System.out.println("Bucket is empty after " + iterationCount + " iterations.");

        /*
         * "continue" is similar to "break" but it's making the loop omit iteration and move to next one.
         */

        System.out.println("Continue example: ");
        int pandaCounter = 0;
        for (int n = 0; n < 10; n++) {
            System.out.println("There are " + n + " panda to add.");
            if (pandaCounter > 20) {
                System.out.println("Too many pandas. ");
                continue;//we skip next lines and comes back to "for"
            }
            System.out.println("We will add some panda to our pandaCounter");
            pandaCounter += n;
            System.out.println(n + " panda added.");
            System.out.println("There are: " + pandaCounter + " pandas now.");
            //much more code that we would like to omit if there are too many pandas
        }

        /*
         * Important thing. "break" ad "continue" statements works only for loop where it was called.
         *
         * It means that it's "breaking" or "continuing" only one level of nested loop
         */
        System.out.println("Nested break example: ");
        int watermelonCounter = 0;
        for (int n = 0; n < 5; n++) {
            for (int m = 0; m < 7; m++) {
                watermelonCounter++;
                System.out.println("Watermelons: " + watermelonCounter);
                if (watermelonCounter >= 10) {
                    System.out.println("Breaking!");
                    break; // it breaks only "for(int m=0; m<7; m++){" loop
                }
            }
        }

        /*
         * For more branching control, there is an labelled version of "continue" and "break".
         *
         * Construction:
         *
         * Label: anyLoop1(){
         *          anyLoop2(){
         *            break Label; // breaks anyLoop1
         *          }
         * }
         *
         * Caution: This construction is considered to be a bad practice.
         * It's similar to "goto" instruction.
         * Code made using this construction is hard to maintain and read.
         *
         */
        System.out.println("Nested break labelled example: ");

        watermelonCounter = 0;

        FirstLoop:
        for (int n = 0; n < 5; n++) {
            SecondLoop:
            for (int m = 0; m < 7; m++) {
                watermelonCounter++;
                System.out.println("Watermelons: " + watermelonCounter);
                if (watermelonCounter >= 10) {
                    System.out.println("Breaking!");
                    break FirstLoop; // it breaks "for (int n = 0; n < 5; n++)" loop
                }
            }
        }

        /*
         * Again. Don't do this.
         */
    }

}
