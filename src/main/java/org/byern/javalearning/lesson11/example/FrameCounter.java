package org.byern.javalearning.lesson11.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krzyspo on 25/04/2017.
 */
public class FrameCounter {

    interface FrameCounterListener {
        void doSomethingOnCount();
    }

    protected List<FrameCounterListener> listeners = new ArrayList<>();

    public void addListener(FrameCounterListener listener){
        listeners.add(listener);
    }

    public void runCounter() throws InterruptedException {
        while (true){
            for (FrameCounterListener listener : listeners){
                listener.doSomethingOnCount();
            }
        }
    }



}
