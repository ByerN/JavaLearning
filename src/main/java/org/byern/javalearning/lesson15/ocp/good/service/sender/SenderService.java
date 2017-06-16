package org.byern.javalearning.lesson15.ocp.good.service.sender;

import org.byern.javalearning.lesson15.ocp.good.constant.MessageType;
import org.byern.javalearning.lesson15.ocp.good.dto.EmailMessage;
import org.byern.javalearning.lesson15.ocp.good.dto.Message;
import org.byern.javalearning.lesson15.ocp.good.dto.SmsMessage;

/**
 * Created by krzyspo on 10/06/2017.
 */
public abstract class SenderService<T extends Message> {
    public abstract void send(T message);
}
