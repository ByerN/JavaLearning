package org.byern.javalearning;

import java.io.IOException;

/**
 * Created by ByerN on 29.05.2017.
 */
public class ServerLauncher {

    public static void main(String[] args) throws IOException {
        new MyServer(Constants.LOCALHOST, Constants.PORT).startListening();
    }
}
