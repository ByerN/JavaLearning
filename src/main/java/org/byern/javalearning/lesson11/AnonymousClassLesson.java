package org.byern.javalearning.lesson11;

/**
 * Created by ByerN on 25.04.2017.
 */
public class AnonymousClassLesson {

    interface SomeInterface {

    }

    static class SomeNormalClass{

    }

    abstract static class SomeAbstractClass {

    }

    public static void main(String[] args) {
        new SomeInterface(){

        };

        new SomeNormalClass(){

        };

        new SomeAbstractClass(){

        };
    }

}
