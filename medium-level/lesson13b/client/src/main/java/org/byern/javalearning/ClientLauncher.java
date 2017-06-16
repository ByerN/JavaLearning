package org.byern.javalearning;

import org.byern.javalearning.impl.ChatMessageEvent;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ByerN on 29.05.2017.
 */
public class ClientLauncher {

    public static void main(String[] args) throws IOException {
        String name = "default";
        if(args.length > 0){
            name = args[0];
        }
        MyClient myClient = new MyClient(name);
        myClient.connect();

        Scanner scanner = new Scanner(System.in);
        String receiver = null;
        while(true){
            String next = scanner.nextLine();

            if(next.startsWith("#TalkTo ")){
                receiver = next.replace("#TalkTo ", "");
            } else if (receiver != null){
                myClient.sendEvent(new ChatMessageEvent(receiver, next));
            } else {
                System.out.println("Start with: #TalkTo name text");
            }
        }
    }

}
