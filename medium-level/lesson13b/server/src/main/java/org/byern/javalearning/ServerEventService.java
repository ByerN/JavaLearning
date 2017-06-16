package org.byern.javalearning;

import org.byern.javalearning.impl.AuthorizedEvent;
import org.byern.javalearning.impl.ChatMessageEvent;
import org.byern.javalearning.impl.HelloEvent;
import org.byern.javalearning.impl.RegisterEvent;
import org.byern.javalearning.resolver.MyChatEventVisitor;

/**
 * Created by ByerN on 29.05.2017.
 */
public class ServerEventService implements MyChatEventVisitor {

    private MyServer myServer;

    public ServerEventService(MyServer myServer) {
        this.myServer = myServer;
    }

    @Override
    public void visit(AuthorizedEvent event) {
        System.out.println("Not supported: " + event);
    }

    @Override
    public void visit(HelloEvent event) {
        System.out.println("Not supported: " + event);
    }

    @Override
    public void visit(RegisterEvent event) {
        myServer.registerNameForToken(event.getToken(), event.getName());
        myServer.sendEvent(event.getToken(), new AuthorizedEvent());
    }

    @Override
    public void visit(ChatMessageEvent event) {
        myServer.sendEvent(event.getTo(), event.getMessage());
    }
}
