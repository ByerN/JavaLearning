package org.byern.javalearning.lesson2;

/**
 * Created by ByerN on 18.02.2017.
 */
public class IfElseIfElseLesson {

    public static void main(String[] args){

        /*
         * "if" construct is one of the main control flow statement
         *
         * Construction:
         *
         * Without block:
         * if(condition) expression; //-> don't use this one - less readable
         *
         * With block:
         * if(condition){
         *  expression;
         * }
         *
         * (Generally control flow statements should be used along with blocks.)
         *
         * Expression will be evaluated only IF condition evaluates to "true".
         * Otherwise, block of code with expression will be omitted.
         */

        boolean trueValue = true;
        boolean falseValue = false;

        if(trueValue){ //same as if(true)
            System.out.println("trueValue passed!"); //Passed.
        }

        if(falseValue){//same as if(false)
            System.out.println("falseValue passed!"); //Haha... nope.
        }

        /*
         * This is the place where the programming starts.
         * Condition can be anything that returns boolean value.
         * Following operators returns boolean value:
         * AND                          &&
         * OR                           ||
         * EQUAL                        ==
         * NOT EQUAL                    !=
         * LESS THAN                    <
         * LESS OR EQUAL THAN           <=
         * GREATER THAN                 >
         * GREATER OR EQUAL THAN        >=
         * INSTANCE OF                  instanceof (This one is a part of OOP)
         * NEGATION                     !
         *
         * Bitwise operators can be used for boolean values because it results with boolean but it's considered
         * to be a bad practice.
         *
         * Of course more complex conditions can be created with other operators.
         * 
         * For boolean logic refer to BooleanLogicLesson
         */

        if(1 < 2){//true
            System.out.println("1 < 2");
        }


        if(2 < 1){//false
            System.out.println("2 < 1");
        }

        if(!(2 < 1)){// !false -> true
            System.out.println("!(2 < 1)");
        }

        if((1+3) > 2){// 4 > 2 -> true
            System.out.println("(1+3) > 2");
        }

        if(1+3 > 2 && 2 < 1){// 4 > 2 && 2 < 1 -> true && false -> false
            System.out.println("1+3 > 2 && 2 < 1");
        }

        /*
         * Along with "if" construction comes "else if" and "else".
         *
         * if(conditionA){ // there can be only one "if".
         *      expressionA;
         * } else if(conditionB){
         *      expressionB;
         * } else if(conditionN){ // there can be unlimited number of "else if"
         *      expressionN;
         * } else { // there can be only one "else".
         *      elseExpression;
         * }
         *
         * Program will go through this construction and check next conditions up to first "true" one.
         * If all conditions are evaluated to "false", "else" branch will be triggered.
         *
         * Caution: too many "if"s in your code usually means that something went wrong.
         * Too many control flow statements in one method increases complexity and makes code less readable.
         */

        if(false){ // false
            System.out.println("false");
        } else { // true
            System.out.println("else1");
        }

        /*
         * Comparision example
         */
        int variableToCheck = 37;

        if(variableToCheck < 10){ //false
            System.out.println(variableToCheck + " < 10");
        } else if(variableToCheck < 20){ //false
            System.out.println(variableToCheck + " < 20");
        } else if(variableToCheck < 30){ //false
            System.out.println(variableToCheck + " < 30");
        } else if(variableToCheck < 40){ //true
            System.out.println(variableToCheck + " < 40");
        } else if(variableToCheck < 50){ //true but omitted -> false
            System.out.println(variableToCheck + " < 50");
        } else { //false
            System.out.println(variableToCheck + " else");
        }

    }
}
