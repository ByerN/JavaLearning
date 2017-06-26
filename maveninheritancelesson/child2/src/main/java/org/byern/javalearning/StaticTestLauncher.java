package org.byern.javalearning;

/**
 * Created by ByerN on 04.06.2017.
 */
public class StaticTestLauncher {

    public static void main(String[] args) {
        Static1[] static1s = {new Static1(), new Static2()};

        for (Static1 item : static1s){
            item.method();
        }

        new Static1().method();
        new Static2().method();

    }
}
