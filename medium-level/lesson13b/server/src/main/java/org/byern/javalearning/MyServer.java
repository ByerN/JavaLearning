package org.byern.javalearning;

import org.byern.javalearning.impl.ChatMessageEvent;
import org.byern.javalearning.impl.HelloEvent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * Created by ByerN on 29.05.2017.
 */
public class MyServer {

    private String host;
    private int port;
    private Map<UUID, Client> clientSockets = new HashMap<>();
    private ServerEventService serverEventService;

    public void registerNameForToken(UUID token, String name) {
        if (clientSockets.containsKey(token)) {
            boolean nameExists = false;
            for (Client client : clientSockets.values()) {
                if (name.equals(client.getName())) {
                    nameExists = true;
                }
            }
            if (!nameExists) {
                clientSockets.get(token).setName(name);
            }
        }
    }

    private interface NewConnectionListener {
        void onNewConnection(Socket socket) throws IOException;
    }

    private static class ListeningThread extends Thread {

        private String host;
        private int port;
        private List<NewConnectionListener> newConnectionListeners = new ArrayList<>();

        public void registerNewConnectionListener(NewConnectionListener listener) {
            newConnectionListeners.add(listener);
        }

        public ListeningThread(String host, int port) {
            this.host = host;
            this.port = port;
        }

        @Override
        public void run() {
            try {
                ServerSocket serverSocket = new ServerSocket();
                serverSocket.bind(new InetSocketAddress(host, port));
                while (true) {
                    System.out.println("Listening for new connection on: " + serverSocket.getInetAddress() + " port: " + serverSocket.getLocalPort());
                    Socket socket = serverSocket.accept();
                    for (NewConnectionListener listener : newConnectionListeners) {
                        listener.onNewConnection(socket);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public MyServer(String host, int port) {
        this.host = host;
        this.port = port;
        this.serverEventService = new ServerEventService(this);
    }

    public void startListening() throws IOException {
        ListeningThread listeningThread = new ListeningThread(host, port);
        listeningThread.registerNewConnectionListener(new NewConnectionListener() {
            @Override
            public void onNewConnection(Socket socket) throws IOException {
                UUID token = UUID.randomUUID();
                Client client = new Client(socket);
                clientSockets.put(token, client);
                sendEvent(client, new HelloEvent(token));

                new Thread() {
                    private Socket socket;

                    public Thread setSocket(Socket socket) {
                        this.socket = socket;
                        return this;
                    }

                    @Override
                    public void run() {
                        try (ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {
                            while (true) {
                                MyEvent event = (MyEvent) input.readObject();
                                System.out.println("Server received: " + event);
                                event.accept(serverEventService);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }.setSocket(socket).start();
            }
        });
        listeningThread.start();
    }

    public void sendEvent(UUID token, MyEvent event) {
        if (clientSockets.containsKey(token)) {
            sendEvent(clientSockets.get(token), event);
        }
    }

    public void sendEvent(String name, String message) {

        for (Client client : clientSockets.values()) {
            if (name.equals(client.getName())) {
                sendEvent(client, new ChatMessageEvent(client.getName(), name, message));
                break;
            }
        }

    }

    private void sendEvent(Client client, MyEvent event) {
        try {
            client.getOut().writeObject(event);
            System.out.println("Server sent: " + event + " to: " + client);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
