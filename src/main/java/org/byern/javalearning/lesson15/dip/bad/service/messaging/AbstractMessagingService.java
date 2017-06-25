package org.byern.javalearning.lesson15.dip.bad.service.messaging;

import lombok.Getter;
import org.byern.javalearning.lesson15.dip.bad.api.constant.MessageType;
import org.byern.javalearning.lesson15.dip.bad.api.dto.Message;
import org.byern.javalearning.lesson15.dip.bad.service.messaging.filter.MessageFilter;
import org.byern.javalearning.lesson15.dip.bad.service.messaging.filter.impl.FooterFilter;
import org.byern.javalearning.lesson15.dip.bad.service.messaging.filter.impl.HeaderFilter;
import org.byern.javalearning.lesson15.dip.bad.service.messaging.filter.impl.PersonalizationFilter;
import org.byern.javalearning.lesson15.dip.bad.service.messaging.filter.impl.TranslationFilter;
import org.byern.javalearning.lesson15.dip.bad.service.sender.SenderService;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by krzyspo on 10/06/2017.
 */
public abstract class AbstractMessagingService implements MessagingServiceFunctionality {
    private final SenderService senderService;

    /*
     * Dependency Inversion principle is violated for some of our
     * cases.
     *
     * For now, we are counting on specific implementation of services
     * instead of abstraction. It makes it complicated when we will
     * want to add specific solutions.
     *
     * For example, we want to use Twilio sms impl provider
     * as our sms message sender. But now, we have only the
     * class named SmsSenderImpl. After implementing this class
     * to use Twilio provider, we are dependant to specific
     * solution instead of abstraction. Now we are not able
     * to add another one simply.
     *
     */


    interface Action {
        void process(AbstractMessagingService serviceAction,
                     Message message);

    }

    /*
     * Default values can be changed via getter
     */
    @Getter
    private final List<MessageFilter> filters = new LinkedList<>(
            Arrays.asList(
                    new FooterFilter(),
                    new HeaderFilter(),
                    new PersonalizationFilter(),
                    new TranslationFilter()
            )
    );

    public AbstractMessagingService(SenderService senderService) {
        this.senderService = senderService;
    }

    public void sendMessage(Message message,
                            MessageType type) {
        for(MessageFilter filter : filters){
            if(filter.isAcceptable(this, message)){
                filter.doFilter(this, message);
            }
        }
        senderService.sendViaSpecificRoute(message, type);
    }

}
