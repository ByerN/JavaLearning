package org.byern.javalearning.lesson2;

import com.sun.org.apache.bcel.internal.util.Objects;

/**
 * Created by ByerN on 18.02.2017.
 */
public class OperatorsLesson {

    public static void main(String[] args) {
        /*
        Operators	            Precedence
        ----------------------------------------------------
        postfix	                expr++ expr--
        unary	                ++expr --expr +expr -expr ~ !
        multiplicative	        * / %
        additive	            + -
        shift	                << >> >>>
        relational	            < > <= >= instanceof
        equality	            == !=
        bitwise AND	            &
        bitwise exclusive OR	^
        bitwise inclusive OR	|
        logical AND	            &&
        logical OR	            ||
        ternary	                ? :
        assignment	            = += -= *= /= %= &= ^= |= <<= >>= >>>=

        Evaluation:
        Assignment operator -> right to left
        else -> left to right
        */

        /*
            int a = 2;
            We have declared variable with name "a", data type of "int" and initialized it with value "2".
            Statements in java always ends with ';' character.
         */
        int a = 2;
        int b = 1;
        int c = a + b; // c = 2 + 1;
        System.out.println(c); //3
        System.out.println(2 - 1); //1
        System.out.println(1 - 2); //-1

        int varToModulo = 4;
        int modulo = 3;
        int moduloResult = varToModulo % modulo; // moduloResult = 1; -> 4/3 == 1 + (1)/3
        System.out.println(moduloResult); //1

        /*
            Traps of evaluation order:
         */
        System.out.println("1+2=" + 1 + 2); //1+2=12
        System.out.println(1 + 2 + "=1+2"); //3=1+2

        /*
            How to fix?

            Use parenthesises. It's making code more readable. It's much easier to avoid bugs.
            Remember to not overdose it.
            int n = ((((1+2))+3)); -> it's not that much readable at all.
         */
        System.out.println("1+2=" + (1 + 2)); //1+2=3
        System.out.println(1 + 2 + "=1+2"); //3=1+2

        /*
            Incrementation/decrementation

            postfix -> increment/decrement after call
            prefix -> increment/decrement before call;

            Caution: Using incrementation/decrementation inside other statement can be misleading.
               Try to avoid using this construction inside more complex statement.

            a++ is equal to a+1
            a-- is equal to a-1
         */
        int toIncrement = 1;
        System.out.println("toIncrement++: " + toIncrement++); //1
        System.out.println("toIncrement: " + toIncrement); //2
        int toIncrement2 = 1;
        System.out.println("++toIncrement2: " + ++toIncrement2); //2

        /*
            Assignment operators
         */
        int var1 = 1;
        var1 += 1; // var1 = var1 + 1;
        var1 -= 1; // var1 = var1 - 1;


        /*
         * Important note:
         *
         * Don't really on comparision operators when comparing objects (e.g. String).
         * use equals or Objects.equals instead
         *
         */

        System.out.println(Objects.equals("a", "b")); // false
        System.out.println(Objects.equals("a", "a")); // true

        System.out.println("a".equals("b")); // false
        System.out.println("a".equals("a")); // true
    }
}
