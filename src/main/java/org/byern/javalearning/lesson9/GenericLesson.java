package org.byern.javalearning.lesson9;

/**
 * Created by ByerN on 02.04.2017.
 */
public class GenericLesson {

    /*
     * Generics - allows to parametrize definition with type.
     *
     * Generics has been invented to add a possibility of creating templates.
     * Some new mechanics are introduced here. Check classes from "lesson9.generics".
     *
     * It provides some helpful things:
     * -Stronger type check at compile time
     * -Casting elimination
     * -Generic algorithms
     *
     * But it has some disadvantages. The most important one is "type erasure"
     * Generics in most are only compile time. It means that generic types are removed
     * after compilation.
     * Too see it, check erased versions of classes in corresponding packages "erased"
     *
     * Check for more information: https://docs.oracle.com/javase/tutorial/java/generics/erasure.html
     *
     * Because of type erasure and the generics nature, some restrictions has to be known
     * when using generics. Check for more information:
     * https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html
     *
     * Unbounded types: Box.java
     * Bounded types: NumberBox.java
     * Extending generic class: IntegerBox.java, DoubleBox.java
     * Wildcards: WildCardPacker.java
     *
     */
}
