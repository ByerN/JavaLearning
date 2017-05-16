package org.byern.javalearning.lesson12;

/**
 * Created by ByerN on 15.05.2017.
 */
public class JoinLesson {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(){
            @Override
            public void run() {

                System.out.println("Thread 1 working...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1 stopped working...");
            }
        };

        Thread thread2 = new Thread(){

            public Thread thread1;

            public Thread setThread1(Thread thread1) {
                this.thread1 = thread1;
                return this;
            }

            @Override
            public void run() {
                System.out.println("Waiting for Thread 1...");
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1 joined...");
            }
        }.setThread1(thread1);

        thread1.start();
        thread2.start();

    }
}
