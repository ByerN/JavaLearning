package org.byern.javalearning.lesson15.dip.good.impl.service.sender;

import org.byern.javalearning.lesson15.dip.good.api.service.sender.SenderService;
import org.byern.javalearning.lesson15.dip.good.api.service.sender.SmsSender;
import org.byern.javalearning.lesson15.dip.good.api.dto.message.SmsMessage;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class SmsSenderImpl implements SmsSender {

    @Override
    public void send(SmsMessage message) {
        //send sms
        System.out.println("Sms: " + message + " sent");
    }
}
