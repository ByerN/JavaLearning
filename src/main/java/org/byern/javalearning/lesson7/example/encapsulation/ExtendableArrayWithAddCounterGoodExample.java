package org.byern.javalearning.lesson7.example.encapsulation;

import java.util.Arrays;

/**
 * Created by ByerN on 26.03.2017.
 */
public class ExtendableArrayWithAddCounterGoodExample {

    private String[] array;
    private int counter = 0;

    public ExtendableArrayWithAddCounterGoodExample() {
        this.array = new String[0];
        this.counter = 0;
    }

    public void addToArray(String value){
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = value;

        //increment counter when added a value to the array
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    //only for test purpose
    //non-getLikeName would be better -> there is no property like arrayLength
    public int getArrayLength(){
        return array.length;
    }
}
