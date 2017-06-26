package org.byern.javalearning.lesson11.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by krzyspo on 25/04/2017.
 */
public class Client {

    private static final Map<String, String> CONSTANT = new HashMap<String, String>();

    static {
        CONSTANT.put("A", "B");
        CONSTANT.put("B", "B");
        CONSTANT.put("C", "B");
        CONSTANT.put("D", "B");
        CONSTANT.put("E", "B");
    }

    {

    }

    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();

        FrameCounter frameCounter = new FrameCounter();

        final int a = 1;

        frameCounter.addListener(
                new FrameCounter.FrameCounterListener() {

                    @Override
                    public void doSomethingOnCount() {
                        System.out.println("Hi! " + a);
                    }
                }
        );

        frameCounter.runCounter();
    }

}
