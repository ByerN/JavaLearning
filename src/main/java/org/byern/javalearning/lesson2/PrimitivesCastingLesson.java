package org.byern.javalearning.lesson2;

/**
 * Created by ByerN on 18.02.2017.
 */
public class PrimitivesCastingLesson {

    public static void main(String[] args) {

        byte a = 0;
        short b = 0;
        int c = 0;
        long d = 0;

        String str = "abc";

        // a = b; //Compilation error: may lose value
        a = (byte) b; //Explicit cast needed.

        /*
        * data types can be casted to other type by using '(dataType) variable' convention
        * Be aware that mostly, types cannot be casted that easy:
        * byte byteVar = (byte)"someText"; //This one will raise compilation error. Cannot be converted.
         */


        b = a; //ok: cannot lose value

        float e = 0.0f;
        double f = 0.0;

        a = (byte) e;

        e = (float) f;
        f = e;

        float divisionExample1 = 2 / 3; //result: 0.0
        float divisionExample2 = 2 / (float)3; //result: 0.6666667
        float divisionExample3 = (float)2 / 3; //result: 0.6666667
        float divisionExample4 = (float)2 / (float)3; //result: 0.6666667
        float divisionExample5 = (float)(2 / 3); //result: 0.0
        float divisionExample6 = 2 / 3.0f; //result: 0.6666667
        //float divisionExample7 = 2 / 3.0; //compilation error: cast to float
        float divisionExample8 = (float) (2 / 3.0); //result: 0.6666667
        float divisionExample9 = 2.0f / 3; //result: 0.6666667
        double divisionExample10 = 2.0d / 3; //result: 0.6666666666666666
    }
}
