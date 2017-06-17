package org.byern.javalearning.lesson1;

/**
 * Created by ByerN on 18.02.2017.
 */
public class CommentsLesson {

    /**
     * This is JavaDoc supported format of comment.
     * If you use this pattern, JavaDoc will be able to create a documentation.
     * <p>
     * If you want to generate javaDoc go to Tools/GenerateJavaDoc (Intellij 2016.2.5)
     *
     * @param args this is description of args.
     */
    public static void main(String[] args) {
        //This is one line comment.

        String text = "SomeText"; //Everything after "//" will be omitted in compilation process

        //If you try
        //to use
        //more then one line
        //of comment -> don't do something like this. It's an ugly way.

        /*
            Try to use this pattern.
            Everything between \/* *\/ ('\' sign has been used to escape characters)
            is not used in compile process.
        */

//        int a;
//        a = 1 + 2;
//        a = a + 3;
//        CTRL + / combination allows to comment selected lines like this

        /*
        int a;
        a = 1 + 2;
        a = a + 3;
        CTRL + SHIFT + / combination allows to comment selected lines like this
        */

        /*
            Caution! Commented code is a bad practice.
         */

        /*
        * This style is also supported.
        * Intellij will add
        * new '*' sign on each new line for better readability.
        *
        */
    }
}
