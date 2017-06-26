package org.byern.javalearning.impl;

import org.byern.javalearning.MyEvent;
import org.byern.javalearning.resolver.MyChatEventVisitor;

/**
 * Created by ByerN on 29.05.2017.
 */
public class ChatMessageEvent implements MyEvent {

    private String to;
    private String from;
    private String message;

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getMessage() {
        return message;
    }

    public ChatMessageEvent(String to, String message) {
        this.to = to;
        this.message = message;
    }

    public ChatMessageEvent(String to, String from, String message) {
        this.to = to;
        this.from = from;
        this.message = message;
    }

    @Override
    public void accept(MyChatEventVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "ChatMessageEvent{" +
            "to='" + to + '\'' +
            ", message='" + message + '\'' +
            '}';
    }
}
