package org.byern.javalearning.lesson15.isp.good.service.messaging.filter;

import org.byern.javalearning.lesson15.isp.good.api.dto.Message;
import org.byern.javalearning.lesson15.isp.good.service.messaging.MessagingServiceFunctionality;

/**
 * Created by krzyspo on 10/06/2017.
 */
public interface MessageFilter {

    boolean isAcceptable(MessagingServiceFunctionality messagingServiceFunctionality,
                         Message message);

    void doFilter(MessagingServiceFunctionality messagingServiceFunctionality,
                  Message message);
}
