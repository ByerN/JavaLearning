package org.byern.javalearning;

import org.byern.javalearning.impl.AuthorizedEvent;
import org.byern.javalearning.impl.ChatMessageEvent;
import org.byern.javalearning.impl.HelloEvent;
import org.byern.javalearning.impl.RegisterEvent;
import org.byern.javalearning.resolver.MyChatEventVisitor;

/**
 * Created by ByerN on 29.05.2017.
 */
public class ClientEventService implements MyChatEventVisitor {

    private MyClient myClient;

    public ClientEventService(MyClient myClient) {
        this.myClient = myClient;
    }

    @Override
    public void visit(AuthorizedEvent event) {
        System.out.println("Authorized!");
    }

    @Override
    public void visit(HelloEvent event) {
        myClient.setToken(event.getToken());
        myClient.sendEvent(new RegisterEvent(myClient.getName(), myClient.getToken()));
    }

    @Override
    public void visit(RegisterEvent event) {
        System.out.println("Unsupported!");
    }

    @Override
    public void visit(ChatMessageEvent event) {
        System.out.println(event.getFrom() + " said: " + event.getMessage());
    }
}
