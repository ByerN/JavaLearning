package org.byern.javalearning;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.UUID;

/**
 * Created by ByerN on 29.05.2017.
 */
public class MyClient {

    private Socket socket;
    private ObjectOutputStream out;
    private UUID token;
    private String name;
    private ClientEventService clientEventService;

    public MyClient(String name) {
        this.name = name;
        this.clientEventService = new ClientEventService(this);
    }

    public UUID getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public void connect() throws IOException {
        socket = new Socket();
        socket.connect(new InetSocketAddress(Constants.LOCALHOST, Constants.PORT));
        out = new ObjectOutputStream(socket.getOutputStream());
        new Thread(){
            private Socket socket;

            public Thread setSocket(Socket socket) {
                this.socket = socket;
                return this;
            }

            @Override
            public void run() {
                try(ObjectInputStream input = new ObjectInputStream(this.socket.getInputStream())){
                    while(true) {
                        MyEvent event = (MyEvent) input.readObject();
                        System.out.println(event);
                        event.accept(clientEventService);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.setSocket(socket).start();

        }

    public void sendEvent(MyEvent event){
        System.out.println("Sent: " + event);
        try {
            out.writeObject(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



