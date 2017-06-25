package org.byern.javalearning.lesson15.dip.good.api.service.sender;

import org.byern.javalearning.lesson15.dip.good.api.dto.message.EmailMessage;
import org.byern.javalearning.lesson15.dip.good.api.service.sender.SenderService;

/**
 * Created by krzyspo on 11/06/2017.
 */
public interface EmailSender extends SenderService<EmailMessage> {
    @Override
    void send(EmailMessage message);
}
