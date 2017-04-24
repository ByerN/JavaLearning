package org.byern.javalearning.lesson8;

/**
 * Created by ByerN on 26.03.2017.
 */
/*
 * "abstract" keyword added. Now this class is abstract
 * and can contain abstract methods.
 */
public abstract class AbstractClassExample {

    protected String someField = "value";

    public AbstractClassExample() {
    }

    public AbstractClassExample(String param) {
    }

    public static void main(String[] args) {
        //new AbstractClassExample(); // error -> abstract classes cannot be instantiated
        //new AbstractClassExample("someValue"); // same as above.




































        //THIS ONE CAN BE CONFUSING!!!
        //Construction called: anonymous class can be used to create an abstract class instance.
        //it looks like that:

        AbstractClassExample anonymousSubclass = new AbstractClassExample(){
            //implementation of abstract things
        };
        System.out.println(anonymousSubclass);//org.byern.javalearning.lesson8.AbstractClassExample$1@28084850
        //more about anonymous classes later.
    }
}
