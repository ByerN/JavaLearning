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

        SomeAbstractClass someAbstractClass = new SomeAbstractClass(){

            int a = 2;

        };

        SomeAbstractClass someAbstractClass2 = new SomeAbstractClass(){

            int b = 2;

            public void hello(){
                System.out.println();
            }
        };
        someAbstractClass.toString();
    }

}
