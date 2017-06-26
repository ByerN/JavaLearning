package org.byern.javalearning.lesson15.dip.good.impl.service.sender;

import org.byern.javalearning.lesson15.dip.good.api.dto.message.EmailMessage;
import org.byern.javalearning.lesson15.dip.good.api.service.sender.EmailSender;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class EmailSenderImpl implements EmailSender {
    @Override
    public void send(EmailMessage message) {
        //send email
        System.out.println("Email: " + message + " sent");
    }
}
