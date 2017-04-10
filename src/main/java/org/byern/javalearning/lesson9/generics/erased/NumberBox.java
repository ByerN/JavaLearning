package org.byern.javalearning.lesson9.generics.erased;

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
 * it will be turned into Number (not Object)
 */
public class NumberBox {

    private Number item; //Box holds an item of T type

    public NumberBox(Number item) {
        this.item = item;
    }

    public Number getItem() { //Object of T type will be returned
        return item;
    }

    public void setItem(Number item) { //Object of T type can be passed as argument
        this.item = item;
    }

    public void itemClass() {
        System.out.println(item != null ? item.getClass().getName() : null);
    }

    public static void main(String[] args) {
        //NumberBox rawBox = new NumberBox("rawItem");//compile error-> String doesn't extend Number
        NumberBox rawBox = new NumberBox(1);
        Integer itemFromRawBox = (Integer) rawBox.getItem(); //getItem returns Number. Has to be casted

        NumberBox integerBox = new NumberBox(1);

        Integer itemFromIntegerBox = (Integer) integerBox.getItem();

        integerBox.setItem(2);
    }
}
