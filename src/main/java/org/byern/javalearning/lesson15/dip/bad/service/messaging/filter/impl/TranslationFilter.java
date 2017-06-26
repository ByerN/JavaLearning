package org.byern.javalearning.lesson15.dip.bad.service.messaging.filter.impl;

import org.byern.javalearning.lesson15.dip.bad.api.dto.Message;
import org.byern.javalearning.lesson15.dip.bad.service.messaging.MessagingServiceFunctionality;
import org.byern.javalearning.lesson15.dip.bad.service.messaging.TranslatableMessagingService;
import org.byern.javalearning.lesson15.dip.bad.service.messaging.filter.MessageFilter;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class TranslationFilter implements MessageFilter {
    @Override
    public boolean isAcceptable(MessagingServiceFunctionality messagingServiceFunctionality,
                                Message message) {
        return TranslatableMessagingService.class.isInstance(messagingServiceFunctionality);
    }

    @Override
    public void doFilter(MessagingServiceFunctionality messagingServiceFunctionality,
                         Message message) {
        ((TranslatableMessagingService)messagingServiceFunctionality).translate(message);
    }
}
