package org.byern.javalearning.impl;

import org.byern.javalearning.MyEvent;
import org.byern.javalearning.resolver.MyChatEventVisitor;

import java.util.UUID;

/**
 * Created by ByerN on 29.05.2017.
 */
public class RegisterEvent implements MyEvent {

    private String name;
    private UUID token;

    public RegisterEvent(String name, UUID token) {
        this.name = name;
        this.token = token;
    }

    public String getName() {
        return name;
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
        return "RegisterEvent{" +
            "name='" + name + '\'' +
            ", token=" + token +
            '}';
    }
}
