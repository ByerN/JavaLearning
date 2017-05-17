package org.byern.javalearning.lesson12;

import java.util.Random;

/**
 * Created by ByerN on 15.05.2017.
 */
public class MemoryInconsistencyExample extends Thread{

    public static int money = 0;

    public static void main(String[] args) throws InterruptedException {
        MemoryInconsistencyExample thread1 = new MemoryInconsistencyExample();
        MemoryInconsistencyExample thread2 = new MemoryInconsistencyExample();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    @Override
    public void run() {
        for(long n=0;n<1000000000;n++){
            incDecMoney();
            //incDecMoneySynchronized();
        }
        System.out.println(this.getName() + " count: " + money);
    }

    public static void incDecMoney(){
        money++;
        money--;
    }

    public static synchronized void incDecMoneySynchronized(){
        money++;
        money--;
    }
}
