package org.byern.javalearning;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by ByerN on 29.05.2017.
 */
public class Client {

    private Socket socket;
    private ObjectOutputStream out;
    private String name;

    public Client(Socket socket) throws IOException {
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
            "socket=" + socket +
            ", out=" + out +
            ", name='" + name + '\'' +
            '}';
    }
}
