package org.byern.javalearning.lesson4;

/**
 * Created by ByerN on 26.02.2017.
 */
public class MethodLesson {

    public static void main(String[] args) {
        /*
         * Method is a construction that makes possibility
         * of code dividing and reusing.
         *
         * Construction: (declaring in class body)
         *
         * declaration:
         * returnType methodName(parameter1DataType parameter1, parameterNDataType parameterN){
         *  //method body
         * }
         *
         * invocation:
         * methodName(argument1, argumentN);
         *
         * If we don't want method to return any value, we use "void" keyword.
         */
        System.out.println("Simple method call");
        sayHello();//simple method invocation
        String name = "ByerN";
        sayHelloWithName(name);//invocation with argument
        System.out.println(createHelloWithNameString(name));//print returned value

        /*
         * IMPORTANT!
         * Arguments are passed via value to methods.
         * For objects -> reference is passed as value.
         *
         */

        int[] simpleArray = {0, 1, 2};
        int simpleNumber = 5;

        logArrayAndNumber(simpleArray, simpleNumber);
        /*
        Reference example:
        simpleArray: 0,1,2,
        simpleNumber: 5
         */
        referenceTest1(simpleNumber, simpleArray);
        logArrayAndNumber(simpleArray, simpleNumber);
        /*
        simpleArray: 100,1,2, //modified in referenceTest1
        simpleNumber: 5
         */
        referenceTest2(simpleNumber, simpleArray);
        logArrayAndNumber(simpleArray, simpleNumber);
        /*
        simpleArray: 100,1,2,
        simpleNumber: 5
         */

        /*
         *
         * Method signature is unique for:
         * -method name
         * -number of parameters
         * -types of parameters
         *
         * It means that:
         * -method with same name and different parameters are two different methods.
         *
         * It can be used for "overloading" (not "overriding")
         *
         */
        System.out.println("Overloaded method call example:");
        int result1 = plus(1, 2);//plus(int a, int b) called
        double result2 = plus(1.0, 2.0);//plus(double a, double b) called
        double result3 = plus(1, 2, 3);//plus(int a, int b, int c) called
        System.out.println("plus(1, 2): " + result1);
        System.out.println("plus(1.0, 2.0): " + result2);
        System.out.println("plus(1, 2, 3): " + result3);
    }

    private static void logArrayAndNumber(int[] simpleArray, int simpleNumber) {
        System.out.println("Reference example:");

        System.out.print("simpleArray: ");
        for(int number : simpleArray){
            System.out.print(number + ",");
        }
        System.out.println();
        System.out.println("simpleNumber: " + simpleNumber);
    }

    public static void referenceTest1(int number, int[] array){
        array[0] = 100;//modified array value even outside method scope
        number = 2;//modified only in this method scope
    }

    public static void referenceTest2(int number, int[] array){
        array = new int[]{100,101,102};//modified only in this method scope
        number = 2;//modified only in this method scope
    }

    public static void sayHello() {
        System.out.println("Hello!");
        return;//return in void methods should be used only for mthod breaking
        //this one is unnecessary
    }

    public static void sayHelloWithName(String name) {
        System.out.println("Hello " + name + "!");
    }

    public static String createHelloWithNameString(String name) {
        return "Hello " + name + "!";
        //Non-void methods always has to return result
    }

    public static String createHiStringIfByerN(String name) {
        if("ByerN".equals(name)){
            return "Hi " + name + "!";
        }
        return "Not hi";//without this line it's a compilation error.
    }


    /*
     * public- is an access modifier (if not provided it's package-private)
     * static- is an keyword that makes method "static" (StaticLesson)- optional
     */
    public static int plus(int a, int b) {//2 parameters declared- int a and int b
        return a + b;//return value from the method
    }

    //overloaded method example
    public static double plus(double a, double b) {
        return a + b;
    }

    //overloaded method example
    public static int plus(int a, int b, int c) {
        return a + b + c;
    }
}
