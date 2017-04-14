package org.byern.javalearning.lesson9.generics;

/**
 * Created by ByerN on 02.04.2017.
 */
/*
 * Following Box class has been created to hold one item of any type.
 *
 * Construction:
 * class ClassName <T>;
 *
 * T is an type parameter. It will be swapped with provided argument
 * on class instance creation.
 *
 * <> -> this is called a diamond. It's an notation of type parameter or argument
 *
 *
 */
public class Box<T> {

    private T item; //Box holds an item of T type

    public Box(T item) {
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
        Box rawBox = new Box("rawItem");//This one is raw. No argument has been passed as T
        //Raw types are allowed for backward compatibility
        //In this case, T type is Object (class)
        String itemFromRawBox = (String) rawBox.getItem(); //getItem returns Object. Has to be casted

        Box<String> stringBox = new Box<String>("stringItem");
        Box<Integer> integerBox = new Box<>(2);
        integerBox.setItem(12);
        /*
        * In "stringBox", "String" type has been passed as argument.
        * For this instance, all T has been swapped to String.
        * It means that "item" is String type now and get is returning String
        */
        String itemFromStringBox = stringBox.getItem();//no cast needed
        /*
         * We use notation like this to pass type as argument in generics:
         * Box<String> stringBox = new Box<String>("stringItem");
         *
         * Java can assume the type as long as it can be retrieved from context.
         * It means that notation like this, will work too:
         * Box<String> stringBox = new Box<>("stringItem");
         *
         * It's much simpler and recommended option.
         *
         */
        stringBox.setItem("otherStringItem");
        //stringBox.setItem(1); //incompatible type (requires String, int passed)
        //Generics allows stronger type control at compile time.

        Box<Box<String>> stringBoxBox = new Box<>(new Box<>("doublePackedString"));
        Box<String> stringBoxFromTheStringBoxBox = stringBoxBox.getItem();
        String stringFromTheStringBoxBox = stringBoxFromTheStringBoxBox.getItem();
    }

    /*
     * Generic types can be also used for methods
     *
     * <GENERIC_TYPE> is used before return type declaration in method signature
     */
    public static <V> V doSomething(V something){
        return something;
    }
}
