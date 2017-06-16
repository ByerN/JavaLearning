package org.byern.javalearning.lesson15.dip.good.api.service.messaging.filter;

import org.byern.javalearning.lesson15.dip.good.api.dto.message.base.Message;
import org.byern.javalearning.lesson15.dip.good.api.service.messaging.MessagingServiceFunctionality;

/**
 * Created by krzyspo on 10/06/2017.
 */
public interface MessageFilter {

    boolean isAcceptable(MessagingServiceFunctionality messagingServiceFunctionality,
                         Message message);

    void doFilter(MessagingServiceFunctionality messagingServiceFunctionality,
                  Message message);
}
