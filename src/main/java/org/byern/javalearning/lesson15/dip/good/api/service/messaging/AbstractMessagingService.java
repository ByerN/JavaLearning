package org.byern.javalearning.lesson15.dip.good.api.service.messaging;

import lombok.Getter;
import org.byern.javalearning.lesson15.dip.good.api.constant.MessageType;
import org.byern.javalearning.lesson15.dip.good.api.dto.message.base.Message;
import org.byern.javalearning.lesson15.dip.good.api.service.messaging.filter.MessageFilter;
import org.byern.javalearning.lesson15.dip.good.api.service.messaging.filter.impl.FooterFilter;
import org.byern.javalearning.lesson15.dip.good.api.service.messaging.filter.impl.HeaderFilter;
import org.byern.javalearning.lesson15.dip.good.api.service.messaging.filter.impl.PersonalizationFilter;
import org.byern.javalearning.lesson15.dip.good.api.service.messaging.filter.impl.TranslationFilter;
import org.byern.javalearning.lesson15.dip.good.api.service.sender.SenderServiceManager;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by krzyspo on 10/06/2017.
 */
public abstract class AbstractMessagingService implements MessagingServiceFunctionality {
    private final SenderServiceManager senderServiceManager;

    @Getter
    private final List<MessageFilter> filters = new LinkedList<>(
            Arrays.asList(
                    new FooterFilter(),
                    new HeaderFilter(),
                    new PersonalizationFilter(),
                    new TranslationFilter()
            )
    );

    public AbstractMessagingService(SenderServiceManager senderServiceManager) {
        this.senderServiceManager = senderServiceManager;
    }

    public void sendMessage(Message message) {
        for(MessageFilter filter : filters){
            if(filter.isAcceptable(this, message)){
                filter.doFilter(this, message);
            }
        }
        senderServiceManager.getSender(message).send(message);
    }

}
