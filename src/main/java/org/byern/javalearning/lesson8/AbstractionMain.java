package org.byern.javalearning.lesson8;

/**
 * Created by ByerN on 26.03.2017.
 */
public class AbstractionMain {

    /*
     * Abstraction paradigm is a one of OOP (Object Oriented Programming) fundamentals.
     *
     * It's purpose is similar to encapsulation's but mechanics are totally different.
     *
     * Abstraction in Java is achieved with abstract classes and interfaces
     *
     * Take a look at examples for more information about the construction of each.
     *
     * There are few important differences between interface and abstract class.
     * Those differences are strictly dispatching which one should be used. There are many
     * comparision available in the web. This one looks readable:
     *
     * Abstract Classes:
     * 1	 abstract class can extend only one class or one abstract class at a time
     * 2	 abstract  class  can extend from a class or from an abstract class
     * 3	 abstract  class  can  have  both  abstract and concrete methods
     * 4	 A class can extend only one abstract class
     * 5	 In abstract class keyword "abstract" is mandatory to declare a method as an abstract
     * 6	 abstract  class can have  protected , public and public abstract methods
     * 7	 abstract class can have  static, final  or static final  variable with any access specifier
     *
     * Interface:
     * 1	 interface can extend any number of interfaces at a time
     * 2     interface can extend only from an interface
     * 3     interface can  have only abstract methods
     * 4     A class can implement any number of interfaces
     * 5     In an interface keyword "abstract" is optional to declare a method as an abstract
     * 6     Interface can have only public abstract methods i.e. by default
     * 7     interface  can  have only static final (constant) variable i.e. by default
     *
     * Source: http://beginnersbook.com/2013/05/abstract-class-vs-interface-in-java/
     *
     * Abstract methods haven't got a body. In Java 8 there is additional "default" keyword
     * that provides a possibility of declaring default implementation for interface's methods
     * (default methods are no longer abstract).
     * Diamond of death problem is resolved by explicitly choosing implementation if conflict appears.
     *
     * https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html
     *
     * Let's stick to Java 7 for now. There will be additional introduction for new features.
     *
     *
     */

}
