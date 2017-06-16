package org.byern.javalearning.lesson13;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ByerN on 21.05.2017.
 */
public class SocketLesson {

    public static final int PORT = 20001;
    public static final String HOST = "localhost";

    static class Server extends Thread {
        private ServerSocket serverSocket;

        public Server() throws IOException {
            this.serverSocket = new ServerSocket();
            this.serverSocket.bind(new InetSocketAddress(HOST, PORT));
        }

        @Override
        public void run() {
            while (true) {
                Socket socket = null;
                try {
                    System.out.println("Server listening at port: " + serverSocket.getLocalPort());
                    socket = serverSocket.accept();
                    System.out.println("New connection accepted at port: " + socket.getPort());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (socket != null) {
                    new Thread() {
                        private Socket socket;

                        public Thread setSocket(Socket socket) {
                            this.socket = socket;
                            return this;
                        }

                        @Override
                        public void run() {
                            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                 PrintWriter out = new PrintWriter(socket.getOutputStream())
                            ) {
                                String nextString;
                                while ((nextString = in.readLine()) != null) {
                                    System.out.println("Server received: " + nextString);
                                    System.out.println("Server responds: " + "Oh, hi! I am server!");
                                    out.println("Oh, hi! I am server!");
                                    out.flush();
                                }
                                System.out.println();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }.setSocket(socket).start();
                }
            }

        }
    }

    static class Client extends Thread {
        private String clientName;
        private String host;
        private int port;

        public Client(String host, int port, String clientName) {
            this.host = host;
            this.port = port;
            this.clientName = clientName;
        }

        @Override
        public void run() {
            Socket socket = null;
            try {
                socket = new Socket(host, port);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (socket != null) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintStream out = new PrintStream(socket.getOutputStream())
                ) {

                    System.out.println("Client " + clientName + " sends: " + "Hi! I am client with name " + clientName);
                    out.println("Hi! I am client with name " + clientName);
                    String nextString;
                    while ((nextString = in.readLine()) != null) {
                        System.out.println("Client " + clientName + " received: " + nextString);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Server().start();
        new Client(HOST, PORT, "Adam").start();
        new Client(HOST, PORT, "Stefan").start();
        new Client(HOST, PORT, "Kamila").start();
    }
}
