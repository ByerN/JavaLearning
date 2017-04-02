package org.byern.javalearning.lesson9.generics;

/**
 * Created by ByerN on 02.04.2017.
 */
public class BoxPackerUtil {

    public static <T> void pack(T item, Box<T> box){
        box.setItem(item);
    }

    public static <T, V extends Box<T>> void packWithMultipleGeneric(T item, V box){
        box.setItem(item);
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>(2);

        pack(1, integerBox);
        BoxPackerUtil.<Integer>pack(1, integerBox);
        //BoxPackerUtil.<Double>pack(2.0, integerBox);//doesn't match
        //pack(1.0, integerBox);//doesn't match

        packWithMultipleGeneric(1, integerBox);

    }
}
