package org.byern.javalearning.lesson1;

/**
 * Created by ByerN on 18.02.2017.
 */
public class PrimitivesLesson {

    /**
     * This is a main method.
     * <p>
     * It's acting like an entry point for program.
     * <p>
     * This is main method convention:
     * public static void main(String[] argumentsName)
     * <p>
     * args -> arguments passed to program in execution process.
     * <p>
     * More about specific keywords later.
     */
    public static void main(String[] args) {

        //1 byte = 8 bits

        /*
            Integer variables:
            byte < short < int < long

            e.g.
            byte 1B -> can hold value between -128 and 127
         */
        //byte variable (1B)
        byte byteVariable = 0;
        //short variable (means shorter integer value) (2B)
        short shortVariable = 0;
        //int variable (integer value) (4B)
        int intVariable = 0;
        //long variable (means longer integer value) (8B)
        long longVariable = 0L;

        /*
            Floating point variables:
            float < double
         */
        //float variable (floating point) (4B)
        float floatVariable = 0.0f;
        //double variable (double precision floating point) (8B)
        double doubleVariable = 0.0;

        //char variable (unicode character) (2B)
        char charVariable = 0;

        /*
            String is an special type of data type.
            It's not an primitive type but it's specially supported by Java
            e.g '+' operator overloaded as string concatenation.
         */
        //String variable (string of chars)
        String stringVariable = "Some string value"; //Default value -> null

        //boolean value (true or false) (1 bit)
        boolean booleanValue = false;

        System.out.println(byteVariable);
        System.out.println(shortVariable);
        System.out.println(intVariable);
        System.out.println(longVariable);
        System.out.println(floatVariable);
        System.out.println(doubleVariable);
        System.out.println(charVariable);
        System.out.println(stringVariable);
        System.out.println(booleanValue);
    }
}
