package org.byern.javalearning.lesson15.srp.bad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class MessagingService {

    /*
     * In this bad example if we would like to change
     * one of the sending process steps, we will have to
     * rewrite the whole class and get an possible regression
     * risk.
     *
     */

    enum MessageType {
        SMS,
        EMAIL
    }

    @AllArgsConstructor
    @Getter
    @Setter
    class Message{
        private String subject;
        private String body;
        private String from;
        private String to;
    }

    public void sendMessage(Message message,
                            MessageType type){
        personalize(message);
        addFooter(message);
        addHeader(message);
        sendViaSpecificRoute(message, type);
    }

    private void personalize(Message message) {
        //some personalization stuff
        translate(message);
    }

    public void sendViaSpecificRoute(Message message,
                                     MessageType type){
        //send message
    }

    public void addFooter(Message message){
        //add footer
    }

    public void addHeader(Message message){
        //add header
    }

    public void translate(Message message){
        //some translation stuff
    }
}
