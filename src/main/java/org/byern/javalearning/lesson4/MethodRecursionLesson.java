package org.byern.javalearning.lesson4;

/**
 * Created by ByerN on 26.02.2017.
 */
public class MethodRecursionLesson {

    public static void main(String[] args) {
        /*
         * Recursive method - method that call itself within it's body
         */
        System.out.println("Recursion example 1:");
        System.out.println(recursionExample1(0, 0));//0
        System.out.println(recursionExample1(0, 1));//2
        System.out.println(recursionExample1(0, 2));//4
        System.out.println(recursionExample1(0, 3));//6
        System.out.println(recursionExample1(0, 4));//8
        System.out.println("Recursion example 2:");
        System.out.println(recursionExample2(2, 0));//2
        System.out.println(recursionExample2(2, 1));//4
        System.out.println(recursionExample2(2, 2));//8
        System.out.println(recursionExample2(2, 3));//16
        System.out.println(recursionExample2(2, 4));//32

        //System.out.println(recursionExample2(2, Integer.MAX_VALUE));//java.lang.StackOverflowError

        /*
         * Too deep recursion may throw stack overflow error. It means that there is no more
         * memory on the stack for method invocation.
         *
         * To avoid this problem:
         * -Make sure that recursion won't go too deep.
         * -Recursive method can be converted into loop-like one.
         * -Increase java stack size
         */
        System.out.println("Recursion converted to loop example 3:");
        System.out.println(recursionIntoLoopExample2(2, 0));//2
        System.out.println(recursionIntoLoopExample2(2, 1));//4
        System.out.println(recursionIntoLoopExample2(2, 2));//8
        System.out.println(recursionIntoLoopExample2(2, 3));//16
        System.out.println(recursionIntoLoopExample2(2, 4));//32

        System.out.println(recursionExample2Decrementing(2, 4));//32
    }

    public static int recursionExample1(int number, int recursionMaxLevel) {
        return recursionExample1(number, 0, recursionMaxLevel);
    }

    public static int recursionExample1(int number, int recursionLevel, int recursionMaxLevel) {
        if (recursionLevel < recursionMaxLevel) {
            number += 2;
            recursionLevel++;
            number = recursionExample1(number, recursionLevel, recursionMaxLevel);
        }
        return number;
    }

    public static int recursionExample2(int number, int recursionMaxLevel) {
        return recursionExample2(number, 0, recursionMaxLevel);
    }

    public static int recursionExample2(int number, int recursionLevel, int recursionMaxLevel) {
        if (recursionLevel < recursionMaxLevel) {
            number += number;
            recursionLevel++;
            number = recursionExample2(number, recursionLevel, recursionMaxLevel);
        }
        return number;
    }

    public static int recursionExample2Decrementing(int number, int recursionLevel) {
        if (recursionLevel > 0) {
            number += number;
            recursionLevel--;
            number = recursionExample2Decrementing(number, recursionLevel);
        }
        return number;
    }

    public static int recursionIntoLoopExample2(int number, int recursionMaxLevel) {
        for (int n = 0; n < recursionMaxLevel; n++) {
            number += number;
        }
        return number;
    }
}
