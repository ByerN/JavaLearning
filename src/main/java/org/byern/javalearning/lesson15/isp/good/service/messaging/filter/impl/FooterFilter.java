package org.byern.javalearning.lesson15.isp.good.service.messaging.filter.impl;

import org.byern.javalearning.lesson15.isp.good.api.dto.Message;
import org.byern.javalearning.lesson15.isp.good.service.messaging.FooterableMessagingService;
import org.byern.javalearning.lesson15.isp.good.service.messaging.MessagingServiceFunctionality;
import org.byern.javalearning.lesson15.isp.good.service.messaging.filter.MessageFilter;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class FooterFilter implements MessageFilter {

    @Override
    public boolean isAcceptable(MessagingServiceFunctionality messagingServiceFunctionality,
                                Message message) {
        return FooterableMessagingService.class.isInstance(messagingServiceFunctionality);
    }

    @Override
    public void doFilter(MessagingServiceFunctionality messagingServiceFunctionality,
                         Message message) {
        ((FooterableMessagingService)messagingServiceFunctionality).addFooter(message);
    }
}
