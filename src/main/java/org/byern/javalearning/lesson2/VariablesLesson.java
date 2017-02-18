package org.byern.javalearning.lesson2;

/**
 * Created by ByerN on 18.02.2017.
 */
public class VariablesLesson {

    /*
     * This is a constant.
     *
     * Constants are static and final.
     * static - means that it can be used in static scope (without class instance).
     * final - means that it's value cannot be changed after initialization.
     *
     * Constants should be declared and initialized at same time.
     */
    public static final int CONSTANT = 1;// + SECOND_CONSTANT; //adding this one will cause illegal forward reference
    public static final int SECOND_CONSTANT = 2 + CONSTANT;//This one works. Declaring order is important.

    /*
     * This is class variable.
     *
     * Class variables are static.
     *
     */
    public static int classVariable;

    /*
     * This is instance variable.
     * It can be used only in instance scope.
     * It will be invisible in "main" method (main method is static and there is no instance of VariablesLesson class)
     */
    public int instanceVariable;

    /*
     * "args" variable is called a "parameter"
     * It's visible within a method where it's declared.
     */
    public static void main(String[] args){

        /*
         * This is local variable.
         * It lives only in block where it was declared(this one will be visible only in "main" method).
         */
        int localVariable = 0;

        /*
         * { } -> it's a code block.
         * Code block is used for scope division.
         * Usually it's in use with other instructions like "if", "while" but it can be used independently.
         */
        {
            localVariable +=1; //this variable is still visible here.

            int localVariableInCodeBlockThatWillBeNotVisibleOutsideTheBlock = 2;
            // a little too long name.
        }
        //localVariableInCodeBlockThatWillBeNotVisibleOutsideTheBlock =1; -> compilation error
        System.out.println(localVariable); //result: 1
    }
}
