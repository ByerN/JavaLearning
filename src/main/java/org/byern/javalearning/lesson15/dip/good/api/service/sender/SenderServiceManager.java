package org.byern.javalearning.lesson15.dip.good.api.service.sender;

import org.byern.javalearning.lesson15.dip.good.api.dto.message.base.Message;

/**
 * Created by krzyspo on 10/06/2017.
 */
public interface SenderServiceManager {
    <T extends Message> void registerSender(Class<T> type,
                                            SenderService<T> senderService);

    SenderService getSender(Message message);
}
