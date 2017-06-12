package org.byern.javalearning.lesson15.isp.good.service.messaging;

import lombok.Getter;
import org.byern.javalearning.lesson15.isp.good.api.constant.MessageType;
import org.byern.javalearning.lesson15.isp.good.api.dto.Message;
import org.byern.javalearning.lesson15.isp.good.service.messaging.filter.MessageFilter;
import org.byern.javalearning.lesson15.isp.good.service.messaging.filter.impl.FooterFilter;
import org.byern.javalearning.lesson15.isp.good.service.messaging.filter.impl.HeaderFilter;
import org.byern.javalearning.lesson15.isp.good.service.messaging.filter.impl.PersonalizationFilter;
import org.byern.javalearning.lesson15.isp.good.service.messaging.filter.impl.TranslationFilter;
import org.byern.javalearning.lesson15.isp.good.service.sender.SenderService;

import java.util.*;

/**
 * Created by krzyspo on 10/06/2017.
 */
public abstract class AbstractMessagingService implements MessagingServiceFunctionality{
    private final SenderService senderService;

    /*
     * Problem with interface segregation has been fixed.
     * There are many different approaches if we want
     * to have single base method that will process all
     * actions desired for specific subclass.
     *
     * This one registers available filters for specific interface
     * in the List. By default it registers basic interfaces.
     *
     * To avoid open-closed principle violation, getter method for filter list
     * is available to add new filter and there is no need
     * of base code modification.
     *
     * Other solutions are to implement sendMessage method
     * in subclasses and use it via polymorphism or to use
     * template method with default implementations.
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
