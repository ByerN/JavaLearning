package org.byern.javalearning.impl;

import org.byern.javalearning.MyEvent;
import org.byern.javalearning.resolver.MyChatEventVisitor;

import java.util.UUID;

/**
 * Created by ByerN on 29.05.2017.
 */
public class HelloEvent implements MyEvent {

    private UUID token;

    public HelloEvent(UUID token) {
        this.token = token;
    }

    public UUID getToken() {
        return token;
    }

    @Override
    public void accept(MyChatEventVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "HelloEvent{" +
            "token=" + token +
            '}';
    }
}
