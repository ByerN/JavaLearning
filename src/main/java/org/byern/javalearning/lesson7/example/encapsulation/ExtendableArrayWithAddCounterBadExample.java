package org.byern.javalearning.lesson7.example.encapsulation;

import java.util.Arrays;

/**
 * Created by ByerN on 26.03.2017.
 */
public class ExtendableArrayWithAddCounterBadExample {

    public String[] array;
    public int counter = 0;

    public ExtendableArrayWithAddCounterBadExample() {
        this.array = new String[0];
        this.counter = 0;
    }

    public void addToArray(String value){
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = value;

        //increment counter when added a value to the array
        counter++;
    }
}
