package org.byern.javalearning.lesson15.isp.good.service.messaging;

import org.byern.javalearning.lesson15.isp.good.api.dto.Message;

/**
 * Created by krzyspo on 10/06/2017.
 */
public interface PersonalizableMessagingService  extends MessagingServiceFunctionality {

    void personalize(Message message);

}
