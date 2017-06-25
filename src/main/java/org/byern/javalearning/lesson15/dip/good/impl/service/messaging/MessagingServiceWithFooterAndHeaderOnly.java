package org.byern.javalearning.lesson15.dip.good.impl.service.messaging;

import org.byern.javalearning.lesson15.dip.good.api.dto.message.base.Message;
import org.byern.javalearning.lesson15.dip.good.api.service.footer.FooterService;
import org.byern.javalearning.lesson15.dip.good.api.service.header.HeaderService;
import org.byern.javalearning.lesson15.dip.good.api.service.messaging.AbstractMessagingService;
import org.byern.javalearning.lesson15.dip.good.api.service.messaging.FooterableMessagingService;
import org.byern.javalearning.lesson15.dip.good.api.service.messaging.HeaderableMessagingService;
import org.byern.javalearning.lesson15.dip.good.api.service.sender.SenderServiceManager;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class MessagingServiceWithFooterAndHeaderOnly extends AbstractMessagingService implements
        FooterableMessagingService, HeaderableMessagingService {

    private final FooterService footerService;
    private final HeaderService headerService;

    public MessagingServiceWithFooterAndHeaderOnly(SenderServiceManager senderServiceManager,
                                                   FooterService footerService,
                                                   HeaderService headerService) {
        super(senderServiceManager);
        this.footerService = footerService;
        this.headerService = headerService;
    }

    @Override
    public void addFooter(Message message) {
        footerService.addFooter(message);
    }

    @Override
    public void addHeader(Message message) {
        headerService.addHeader(message);
    }
}
