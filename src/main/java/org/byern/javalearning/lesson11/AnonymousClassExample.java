package org.byern.javalearning.lesson11;

/**
 * Created by krzyspo on 25/04/2017.
 */
public class AnonymousClassExample {


    interface Hellower{

        void hello();

    }

    public static void main(String[] args) {

        AnonymousClassExample item = new AnonymousClassExample();

        item.sayHello(
                new Hellower() {
                    @Override
                    public void hello() {
                        System.out.println("Hi 1");
                    }
                }
        );


        item.sayHello(
                new Hellower() {
                    @Override
                    public void hello() {
                        System.out.println("Hi 2");
                    }
                }
        );
    }

    public void sayHello(Hellower hellower){
        hellower.hello();
    }

}
