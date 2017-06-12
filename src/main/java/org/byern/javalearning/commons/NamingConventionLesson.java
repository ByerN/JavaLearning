package org.byern.javalearning.commons;

/**
 * Created by ByerN on 18.02.2017.
 */
/*
 * Class naming -> PascalCase (UpperCamelCase)
 */
public class NamingConventionLesson {

    /*
     * Java is case sensitive
     */

    /*
     * Constants naming -> UPPER_SNAKE_CASE
     *
     * Try to use only alphanumeric characters (without numbers if it's not needed)
     * Do not use '$', '_'(this one only in constant as separator) in names (there are some excuses)
     */
    public static final int CONSTANT_VALUE = 1;

    /*
     * Variable naming -> camelCase
     *
     *  Variable should be described with nouns.
     */
    private int variableCase;

    /*
     * Method naming -> camelCase
     *  Methods should describe what are they doing (usage of verbs).
     */
    public void doSomethingWith(int variableToDoSomethingWith){
        //Empty methods are usually a bad practice
    }

}
