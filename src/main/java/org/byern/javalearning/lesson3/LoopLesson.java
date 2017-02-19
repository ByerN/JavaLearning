package org.byern.javalearning.lesson3;

/**
 * Created by ByerN on 19.02.2017.
 */
public class LoopLesson {

    public static void main(String[] args) throws InterruptedException {
        /*
         * "while" loop is a statement that executes a code block while specified condition is evaluated to "true".
         *
         * Construction:
         *
         * while (condition) {
         *  codeToExecute
         * }
         *
         * while (condition) //not recommended
         *  codeToExecute
         *
         * Condition is checked before entering to loop and after each loop iteration.
         */

        /*
        while(true){ //infinite loop -> this one will hang up the program
            //doSomething
        }
        */

        System.out.println("While loop with counter example:");
        int counter = 0;
        while(counter < 10){
            System.out.println("Counter is: " + counter);
            counter++;
        }

        /*
         * Along with "while" loop comes "do while".
         *
         * Construction:
         *
         * do {
         *  //doSomething
         * } while(condition); //Code blocks never ends with ';'.
         *
         * It's similar to "while" but condition is checked at the iteration end.
         * "doSomething" will be executed at least once.
         */

        System.out.println("Do while loop with counter example:");

        int counterForDoWhile = 0;
        do {
            System.out.println("Counter is: " + counterForDoWhile);
            counterForDoWhile++;
        } while (counterForDoWhile < 10);

        do {
            System.out.println("I'll be executed at least once");
        } while (false);

        /*
        while (false) {
            System.out.println("I'll be never executed!");
            //compilation error: unreachable statement. This part of code will be never executed
        }
        */
        boolean conditionA = false;
        while (conditionA){
            System.out.println("I'll be never executed!");
        }

        /*
         * "while" and "do while" loops can be dangerous. It's easy to make a mistake and create infinite loop.
         *
         * More commonly used type of loops are "for" loops.
         *
         * "for" loop comes in two constructions.
         *
         * First one:
         *
         * for(initialization; condition; incrementExpression){
         *  //doSomething
         * }
         *
         * Example (doSomething 10 times):
         *
         * for(int n = 0; n< 10; n++){
         *  //doSomething
         * }
         *
         * -initialization- initialize variable visible only in "for" loop code block.
         * -condition- same as in "while" loop.
         * -incrementExpression- expression made at the loop iteration end
         *
         * -> all statements mentioned above are optional:
         * for(;;){ //it still works -> infinite loop
         *  //doSomething
         * }
         *
         * for(int n = 0; n< 10; n++){
         *  //doSomething
         * }
         *
         * is and equivalent of:
         *
         * int n = 0;
         * while(n < 10){
         *  //doSomething
         *  n++;
         * }
         *
         *
         */

        System.out.println("For loop with counter example 1:");
        for(int n = 0; n< 10; n++){
            System.out.println("Counter is: " + n);
        }

        System.out.println("For loop with counter example 2 (multiple loop variables):");
        for(int n = 2, m = 4; m%n!=3; n+=1, m+=5){ //less common used. Hard to read.
            System.out.println("Counter is: " + n);
        }

        System.out.println("Nesting loops example:");
        for(int n = 0; n < 10; n++){
            for(int m = 0; m < 10; m++) {
                System.out.println("n: " + n + ", m: " + m);
            }
        }

        /*
         * Second "for" loop construction is called a "for each" or "enhanced for".
         * It's used to loop through array/collections types.
         *
         * Construction:
         *
         *  for(variableFromCollection: collection){
         *      //doSomething
         *  }
         *
         * more about arrays in ArraysLesson.
         */

        System.out.println("For each loop example:");
        int[] intArray = {0, 2, 3, 8};
        for(int number : intArray){
            System.out.println("Number: " + number);
        }

        /* //Some funny things
        for(int n=0; n< 10000; n++){
            if(n % 10 == 0){
                System.out.println("   x   ");
            } else if(n % 10 == 1){
                System.out.println("  xxx  ");
            } else if(n % 10 == 2){
                System.out.println(" xxxxx ");
            } else if(n % 10 == 3){
                System.out.println("  xxx  ");
            } else if(n % 10 == 4){
                System.out.println("  xxx  ");
            } else if(n % 10 == 5){
                System.out.println("  xxx  ");
            } else if(n % 10 == 6){
                System.out.println("  xxx  ");
            } else if(n % 10 == 7){
                System.out.println("  xxx  ");
            } else if(n % 10 == 8){
                System.out.println("  xxx  ");
            } else if(n % 10 == 9){
                System.out.println("  xxx  ");
            }

            Thread.sleep(300);
        }
        */
    }
}
