package org.byern.javalearning.lesson4;

/**
 * Created by ByerN on 26.02.2017.
 */
public class StaticLesson {

    public String nonStaticVariable = "Hi non static!";
    public static String staticVariable = "Hi static!";

    public static void main(String[] args) {
        /*
         * Static keyword makes class property "static".
         *
         * It means that it will be accessible from static scope (class instance not needed)
         * and memory for it will be allocated only once.
         *
         * Static field isn't instance dependant.
         *
         * Static usage should be limited as much as possible.
         * It's usually used for:
         * -constants
         * -stateless utility-like methods (Math class is a good example)
         *
         * Overdosing statics usually turns program into a bug factory.
         */

        //create 2 instances of StaticLesson class
        StaticLesson staticLesson1 = new StaticLesson();
        StaticLesson staticLesson2 = new StaticLesson();

        System.out.println("Static example:");

        System.out.println("staticLesson1.staticVariable: " + staticLesson1.staticVariable);
        //Referring to static property via class instance is a bad practice.
        //Can be misleading. Developer could think that this property is in instance context.
        System.out.println("staticLesson2.staticVariable: " + staticLesson2.staticVariable);
        //Static properties should be referred via ClassName.staticProperty
        System.out.println("StaticLesson.staticVariable: " + StaticLesson.staticVariable);
        System.out.println("staticLesson1.nonStaticVariable: " + staticLesson2.nonStaticVariable);
        System.out.println("staticLesson2.nonStaticVariable: " + staticLesson2.nonStaticVariable);
        /*
        Static example:
        staticLesson1.staticVariable: Hi static!
        staticLesson2.staticVariable: Hi static!
        StaticLesson.staticVariable: Hi static!
        staticLesson1.nonStaticVariable: Hi non static!
        staticLesson2.nonStaticVariable: Hi non static!
         */
        staticLesson1.nonStaticVariable = "Hello staticLesson1";
        staticLesson2.nonStaticVariable = "Hello staticLesson2";
        staticLesson1.staticVariable = "Hello staticLesson1";
        staticLesson2.staticVariable = "Hello staticLesson2";

        System.out.println("(after modification):");

        System.out.println("staticLesson1.staticVariable: " + staticLesson1.staticVariable);
        System.out.println("staticLesson2.staticVariable: " + staticLesson2.staticVariable);
        System.out.println("StaticLesson.staticVariable: " + StaticLesson.staticVariable);
        System.out.println("staticLesson1.nonStaticVariable: " + staticLesson2.nonStaticVariable);
        System.out.println("staticLesson2.nonStaticVariable: " + staticLesson2.nonStaticVariable);
        /*
        (after modification):
        staticLesson1.staticVariable: Hello staticLesson2 //it's not Hello staticLesson1
        staticLesson2.staticVariable: Hello staticLesson2
        StaticLesson.staticVariable: Hello staticLesson2
        staticLesson1.nonStaticVariable: Hello staticLesson2
        staticLesson2.nonStaticVariable: Hello staticLesson2
         */
    }
}
