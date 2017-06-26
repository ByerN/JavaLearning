package org.byern.javalearning.lesson15.ocp.good.service.sender;

import org.byern.javalearning.lesson15.ocp.good.dto.EmailMessage;
import org.byern.javalearning.lesson15.ocp.good.dto.Message;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class EmailSender extends SenderService<EmailMessage>{
    @Override
    public void send(EmailMessage message) {
        //send email
    }
}
