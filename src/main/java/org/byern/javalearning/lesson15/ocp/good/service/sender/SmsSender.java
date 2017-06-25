package org.byern.javalearning.lesson15.ocp.good.service.sender;

import org.byern.javalearning.lesson15.ocp.good.dto.Message;
import org.byern.javalearning.lesson15.ocp.good.dto.SmsMessage;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class SmsSender extends SenderService<SmsMessage>{

    @Override
    public void send(SmsMessage message) {
        //send sms
    }
}
