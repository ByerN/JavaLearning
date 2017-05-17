package org.byern.javalearning.lesson12;

/**
 * Created by ByerN on 15.05.2017.
 */
public class ThreadLesson {

    /**
     * Simple threads can be created two ways:
     * -by creating Thread subclass
     * -by passing Runnable implemented class to the thread
     *
     * There are 2 important methods:
     *
     * run() -> implement/override for thread behavior description
     * start() -> start thread
     *
     */

    public static void main(String[] args) {
        Thread threadFromThreadClass = new Thread(){
            @Override
            public void run() {
                while (true){
                    System.out.println("Hi from threadFromThreadClass");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        threadFromThreadClass.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("Hi from threadFromRunnable");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };

        Thread threadFromRunnable = new Thread(runnable);
        threadFromRunnable.start();

        /*
         * Threads will run even if main method will exit
         */

        /*
         * interrupt() method is setting interrupt flag (causes InterruptedException for sleep() and other similar methods)
         * If you want to check interrupt flag use: isInterrupted()
         */
        /*
        threadFromThreadClass.interrupt();
        threadFromRunnable.interrupt();
        */

        //If you want to exit threads on main exit use:
        //System.exit(0);

        /*
         * Check also setDaemon(true) -> daemons closes immediately (resource can be not cleaned!)
         */


    }
}
