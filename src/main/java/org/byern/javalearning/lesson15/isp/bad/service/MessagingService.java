package org.byern.javalearning.lesson15.isp.bad.service;

import org.byern.javalearning.lesson15.isp.bad.api.constant.MessageType;
import org.byern.javalearning.lesson15.isp.bad.api.dto.Message;
import org.byern.javalearning.lesson15.isp.bad.service.sender.SenderService;

/**
 * Created by krzyspo on 10/06/2017.
 */
public abstract class MessagingService {
    private final SenderService senderService;

    /*
     * This is an example of violating interface segregation
     * principle. One Template abstract class created with multiple
     *
     * Now every messaging impl has to implement
     * all methods event if it doesn't need it.
     */

    public MessagingService(SenderService senderService) {
        this.senderService = senderService;
    }

    public abstract void personalize(Message message);
    public abstract void translate(Message message);
    public abstract void addFooter(Message message);
    public abstract void addHeader(Message message);

    public void sendMessage(Message message,
                            MessageType type){
        personalize(message);
        translate(message);
        addFooter(message);
        addHeader(message);
        senderService.sendViaSpecificRoute(message, type);
    }

}
