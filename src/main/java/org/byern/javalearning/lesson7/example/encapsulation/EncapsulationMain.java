package org.byern.javalearning.lesson7.example.encapsulation;

/**
 * Created by ByerN on 26.03.2017.
 */
public class EncapsulationMain {

    /*
     * Encapsulation paradigm -> limiting access/visibility of object's components.
     *
     * It's used for one reason:
     * -hiding implementation data (low level in comparision with abstraction paradigm)
     *      to avoid bugs and increase readability.
     *      Setting proper access makes programmer know what can he use
     *      and what is prohibited for him
     *
     * In Java we use access modifiers.
     *
     * Access modifiers can be used when defining class components and class itself.
     *
     * There are 4 access modifiers:
     * public -> available for all
     * protected -> available for inheritance (and package)
     * package-private -> available for other classes in packet
     * private -> available only for class itself
     *
     *
     *              Access Levels
     *   Modifier	    Class	Package	Subclass	World
     *   public	        Y	    Y	    Y	        Y
     *   protected	    Y	    Y	    Y	        N
     *   no modifier	Y	    Y	    N	        N
     *   private	    Y	    N	    N	        N
     *
     * There are some rules when defining access level and the most important are:
     * -Use the most restrictive access level that makes sense for a particular member.
     *      Use private unless you have a good reason not to.
     * -Avoid public fields except for constant.
     * -Avoid no modifier unless you know what are you doing. Package-moving based refactoring
     *      can break access.
     *
     * Source: https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     * For getting and setting the object's fields, "getters" (Accessors) and "setters"(Mutators) are used.
     * By convention:
     * - getter is a method that starts with a "get" word and ends with property name
     * - setter is a method that starts with a "set" word (or "is" for boolean) and ends with
     *      property name.
     * - getter is used for making possibility of read the private field.
     * - setter is used for making possibility of write the private field.
     *
     * Try use alt+insert and generate the setters/getters for class with fields.
     *
     * Check: AccessorsMutatorsMain
     *
     * Getters/Setters are only convention. It's not supported by Java itself but it's often used
     * by other libraries. Be careful with using "get" and "set" prefixes if your method is not a
     * setter or getter. And don't name boolean property as isSomething because it's the conventional
     * name of boolean setter.
     */
    public static void main(String[] args) {

        ExtendableArrayWithAddCounterBadExample badOne = new ExtendableArrayWithAddCounterBadExample();
        badOne.addToArray("1");
        badOne.addToArray("2");
        badOne.addToArray("3");

        System.out.println(badOne.counter + " = " + badOne.array.length);

        badOne.counter = 10000;
        /*
         * terrible things happened here. A programmer changed the internal state of the object.
         * Now the data is corrupted. "counter" is indicating that "add" operation has been invoked
         * 10000 times but it was only 3 times.
         */

        System.out.println(badOne.counter + " != " + badOne.array.length);

        ExtendableArrayWithAddCounterGoodExample goodOne = new ExtendableArrayWithAddCounterGoodExample();
        badOne.addToArray("1");
        badOne.addToArray("2");
        badOne.addToArray("3");

        System.out.println(goodOne.getCounter() + " = " + goodOne.getArrayLength());

        //goodOne.counter = 10000; // cannot be accessed. Compilation error
        /*
         * counter cannot be changed externally. Only addToArray can change it's value.
         */
        badOne.addToArray("4");
        System.out.println(goodOne.getCounter() + " = " + goodOne.getArrayLength());
    }
}
