package org.byern.javalearning.lesson5;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ByerN on 01.03.2017.
 */
public class ExceptionsLesson {

    public static void main(String[] args) {
        /*
         * "An exception is an event, which occurs during the execution of a program,
         * that disrupts the normal flow of the program's instructions."
         *
         * More:
         * https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html
         *
         * Exceptions can be divided into 3 groups:
         * Exception (checked)
         * RuntimeException (not checked)
         * Error (not checked)
         *
         * Check those classes inheritance to find out how they are related to each other:
         *
         *                      Throwable
         *                          |
         *  -------------------------------------
         * |                                    |
         * -----                                ---------
         * Error                                Exception
         * -----                                ---------
         *                                      |       | Other checked exceptions
         *                        ----------------
         *                        RuntimeException
         *                        ----------------
         *                        other runtime exceptions
         *
         * We can try to catch an exception and finally perform some cleanup if our application
         * cannot get up after failure.
         *
         * It comes with an try-catch construction:
         *
         * Construction:
         * try{
         *      //do some code that can throw exception
         * }catch(ExceptionType exceptionVariable){
         *      //do something if bad thing happens
         * }
         *
         * ExceptionType -> implements Throwable (extends Exception or RuntimeException)
         *
         * "[...]and finally perform some cleanup if our application
         * cannot get up after failure." -> means finally keyword.
         *
         * How it works:
         * try{
         *      //do some code that can throw exception
         * }catch(ExceptionType exceptionVariable){
         *      //do something if bad thing happens
         * }finally{
         *      //do clean up
         * }
         *
         * finally block executes ALWAYS when try-catch block exits.
         * Even if you use break.
         * Even if you use return.
         * Even if some weird cosmic exception will be thrown.
         * It will execute.
         *
         * finally block is usually used for cleaning up. Closing resources for example.
         */

        System.out.println("Exception example1: ");
        try {
            System.out.println("Try block entered");
            String string = null;
            System.out.println("Before NPE");
            string.toString();//NullPointerException -> trying to use a method of non existing object
            System.out.println("We shouldn't be here");
        } catch (Exception e) {//catch all exceptions (don't do it)
            System.out.println("In catch block");
            e.printStackTrace();//print a stack trace to console
        } finally {
            System.out.println("In finally block");
        }

        /*
        This is a stack trace:

        java.lang.NullPointerException
            at org.byern.javalearning.lesson5.ExceptionsLesson.main(ExceptionsLesson.java:71)
            at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
            at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
            at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
            at java.lang.reflect.Method.invoke(Method.java:606)
            at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)

        It's a simple log of the stack frames showing where the exception occurred
        at org.byern.javalearning.lesson5.ExceptionsLesson.main(ExceptionsLesson.java:71)
        -> ExceptionsLesson.java line 71
         */

        /*
         * Catching runtime exceptions can be not the best idea:
         * -RuntimeExceptions are created for hard or impossible to recover
         * -If you try to catch an NullPointerException you cannot be sure where NPE
         * has been thrown. This problem makes is similar to one below:
         *
         * Catching generic exceptions like Exception, RuntimeException etc is a bad practice.
         * You have no idea what have been catch here. It's hard to make a proper
         * reaction to an unknown problem
         *
         * Catching "Throwable" is even worse:
         * -Throwable means an "Error" too. When Error is thrown- application is usually dying.
         * E.g: OutOfMemoryError, StackOverflowError
         *
         */

        System.out.println("Exception example2: ");
        testException();
    }

    /*
     * There can be multiple catch blocks.
     * Order is important:
     * -It stops on first catch one
     * -Subclass will not be catch if superclass has been catch before (compilation error)
     */
    public static void testException() {
        try {
            String string = null;
            string.toString();
        } catch (RuntimeException e) {
            System.out.println("In catch block RuntimeException");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("In catch block Exception");
            e.printStackTrace();
        } finally {
            System.out.println("In finally block");
        }
    }

    public static void testException2() {
        try {
            String string = null;
            string.toString();
        } catch (Exception e) {
            System.out.println("In catch block Exception");
            e.printStackTrace();
        } /*catch (RuntimeException e) { //Compilation error: exception java.lang.RuntimeException has already been caught
            System.out.println("In catch block RuntimeException");
            e.printStackTrace();
        }*/ finally {
            System.out.println("In finally block");
        }
    }

    /*
     * Multiple exceptions can be assigned to one catch using '|'
     */
    public static void testException3() {
        try {
            String string = null;
            string.toString();
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("In catch block Exception");
            e.printStackTrace();
        } finally {
            System.out.println("In finally block");
        }
    }

    /*
     * If exception will not be catch - It will be throw higher.
     */
    public static void testException4() {
        /*
        try {
            String string = null;
            string.toString();
        } catch (IllegalArgumentException e) {
            System.out.println("In catch block Exception");
            e.printStackTrace();
        } finally {
            System.out.println("In finally block");
        }
        //NPE not catch -> thrown higher
        */
    }

    /*
     * What is the difference between checked and non-checked exceptions:
     * -checked exceptions has to be catch or rethrown
     *
     * If we want to rethrow checked exception higher we use an "throws" keyword in method signature
     *
     */

    public static void testCheckedExceptionCatcher() {
        try {
            testCheckedExceptionThrower();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
    if we don't explicitly tell that method throws checked exception or
    try to catch it inside the method -> it's compilation error
    */
    public static void testCheckedExceptionThrower() throws InterruptedException {
        Thread.sleep(10);
    }

    /*
     * Don't add non-checked exceptions (inheriting from RuntimeException)
     * to the method signature. RuntimeExceptions has been created for other reason
     * then checked one and we shouldn't explicitly tell that method throws it.
     *
     * Non-checked exception can be indicated in javaDoc for example to tell developer
     * that method can throw it if method contract has been broken
     */

    /*
     * if we want to throw exception we use following construction:
     */

    public static void throwExceptionMethod1() {
        throw new IllegalArgumentException(); //throws runtime exception
    }

    public static void throwCheckedExceptionMethod1() throws IOException { // throws Exception works too but
        //it shadows main one.
        throw new IOException();
    }

    /*
     * There is another construct that can be useful in exception context.
     * It's called try-with-resources
     *
     * It's used for automatic close the resources (usually it's when we handle a file or networking)
     *
     * Works only for classes implementing java.lang.AutoCloseable
     *
     * -Resources are closed before catch and finally
     * -Exceptions thrown when closing resource are suppressed
     */

    public static void testTryWithResource() throws IOException {
        //create resource that will be cleaned after finishing try catch block.
        //multiple resources can be provided by separating it with ";"
        try (FileReader reader = new FileReader("something")) {

        } catch (IOException e) {
            e.printStackTrace();
        }

        //In this construction we can get rid of "catch" (explicitly throws because FileReader needs it)
        try (FileReader reader = new FileReader("something")) {

        }

        /*No auto-closeable -> compilation error
        try(ExceptionsLesson exceptionsLesson = new ExceptionsLesson()){

        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
