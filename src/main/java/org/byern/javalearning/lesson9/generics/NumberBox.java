package org.byern.javalearning.lesson9.generics;

/**
 * Created by ByerN on 02.04.2017.
 */
/*
 * Following Box class has been created to hold one item of Number type.
 *
 * Construction:
 * class ClassName <T extends Number>;
 *
 * T is an type parameter. It will be swapped with provided argument
 * on class instance creation.
 *
 * <> -> this is called a diamond. It's an notation of type parameter or argument
 *
 * <T extends Number> means that T has to extend the Number class
 * This one is called a Bounded type. It's bounded to specific type (Number) and after compilation
 * it will be turned into Number (not Object).
 *
 * extends here means not only extending class but also implementing an interface
 *
 * Bounding can be also used for multiple types. It looks like this:
 * <T extends ClassA & ClassB & ClassN>
 * Now it means that T has to extend ClassA, ClassB and ClassN
 *
 * "A type variable with multiple bounds is a subtype of all the types listed in the bound.
 * If one of the bounds is a class, it must be specified first"
 * https://docs.oracle.com/javase/tutorial/java/generics/bounded.html
 *
 *
 */
public class NumberBox<T extends Number> {

    private T item; //Box holds an item of T type

    public NumberBox(T item) {
        this.item = item;
    }

    public T getItem() { //Object of T type will be returned
        return item;
    }

    public void setItem(T item) { //Object of T type can be passed as argument
        this.item = item;
    }

    public void itemClass() {
        System.out.println(item != null ? item.getClass().getName() : null);
    }

    public static void main(String[] args) {
        //NumberBox rawBox = new NumberBox("rawItem");//compile error-> String doesn't extend Number
        NumberBox rawBox = new NumberBox(1);
        Integer itemFromRawBox = (Integer) rawBox.getItem(); //getItem returns Number. Has to be casted

        NumberBox<Integer> integerBox = new NumberBox<>(1);

        Integer itemFromIntegerBox = integerBox.getItem();//no cast needed

        integerBox.setItem(2);
        //stringBox.setItem(1.0); //incompatible type (requires Integer, Double passed)

        //NumberBox<NumberBox<Integer>> stringBoxBox = new NumberBox<>(new NumberBox<>(1));
        //doesn't work. NumberBox doesn't extend Number
    }
}
