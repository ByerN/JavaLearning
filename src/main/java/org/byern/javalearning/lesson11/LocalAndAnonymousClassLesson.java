package org.byern.javalearning.lesson11;

import java.util.Date;

/**
 * Created by ByerN on 24.04.2017.
 */
public class LocalAndAnonymousClassLesson {

    /*
     * Local class
     *
     * Local and inner classes cannot have a static members
     */

    public static void main(String[] args) {

        final Date date = new Date();

        class LocalClass {

            int localClassVariable = 2;
            LocalClass(){
                date.setTime(10);
            }
        }

        LocalClass localClassObject = new LocalClass();
        localClassObject.localClassVariable = 3;

    }

}
