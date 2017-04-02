package org.byern.javalearning.lesson9;

/**
 * Created by ByerN on 02.04.2017.
 */
public class PrimitiveBoxingLesson {

    /*
     * Java as objective language, provides wrapper classes for primitives.
     *
     * https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html
     *
     * Primitive type	Wrapper class
     * ------------------------------
     * boolean	        Boolean
     * byte	            Byte
     * char	            Character
     * float	        Float
     * int	            Integer
     * long	            Long
     * short	        Short
     * double	        Double
     *
     * When operating on primitives and it's wrappers there are two operations
     * that can be executed non explicitly:
     *
     * Autoboxing- automatic conversion from primitive to wrapper class
     * Unboxing- automatic conversion from wrapper class to primitive
     *
     * Wrapper classes objects has to be compared with equals.
     * "==" operator is not reliable for this case
     */

    public static void main(String[] args) {
        int aInt = 2;
        Integer aInterger = aInt; //autoboxed
        //same as: Integer aInterger = Integer.valueOf(aInt);

        aInt = aInterger;//unboxed

        //same as: aInt = aInterger.intValue();

        /*
         * Wrapper class variables can be null same like other object variables.
         * It can cause NPE when unboxing.
         */

        aInterger = null;
        //aInt = aInterger;//compiles but NPE in runtime

        /*
         * Wrapper classes provides some helpful methods
         * Check methods available for example for Integer class (static and instance)
         */

        System.out.println("Number : " + 1);//non explicit boxing
        System.out.println("Number : " + Integer.valueOf(1).toString());//same as above but explicit

        System.out.println(new Integer(2) == new Integer(2));//false
        System.out.println(new Integer(2).equals(2));//true
    }

    /*
     * integer equals method:
     *     public boolean equals(Object obj) {
     *        if (obj instanceof Integer) {
     *            return value == ((Integer)obj).intValue();
     *        }
     *        return false;
     *    }
     */
}
