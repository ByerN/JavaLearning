package org.byern.javalearning.lesson15.dip.good.api.service.sender;

import org.byern.javalearning.lesson15.dip.good.api.dto.message.base.Message;

/**
 * Created by krzyspo on 10/06/2017.
 */
public interface SenderService<T extends Message> {
    void send(T message);
}
