package org.byern.javalearning.lesson15.dip.good.impl.service.messaging;

import org.byern.javalearning.lesson15.dip.good.api.dto.message.base.Message;
import org.byern.javalearning.lesson15.dip.good.api.service.footer.FooterService;
import org.byern.javalearning.lesson15.dip.good.api.service.messaging.AbstractMessagingService;
import org.byern.javalearning.lesson15.dip.good.api.service.messaging.FooterableMessagingService;
import org.byern.javalearning.lesson15.dip.good.api.service.sender.SenderServiceManager;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class MessagingServiceWithFooterOnly extends AbstractMessagingService implements
        FooterableMessagingService {

    private final FooterService footerService;

    public MessagingServiceWithFooterOnly(SenderServiceManager senderServiceManager,
                                          FooterService footerService) {
        super(senderServiceManager);
        this.footerService = footerService;
    }

    @Override
    public void addFooter(Message message) {
        footerService.addFooter(message);
    }

}
