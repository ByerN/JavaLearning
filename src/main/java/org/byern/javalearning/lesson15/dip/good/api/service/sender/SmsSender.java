package org.byern.javalearning.lesson15.dip.good.api.service.sender;

import org.byern.javalearning.lesson15.dip.good.api.dto.message.SmsMessage;

/**
 * Created by krzyspo on 10/06/2017.
 */
public interface SmsSender extends SenderService<SmsMessage>{
    void send(SmsMessage message);
}
