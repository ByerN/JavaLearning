package org.byern.javalearning.lesson15.dip.bad.service.messaging.impl;

import org.byern.javalearning.lesson15.dip.bad.api.dto.Message;
import org.byern.javalearning.lesson15.dip.bad.service.FooterService;
import org.byern.javalearning.lesson15.dip.bad.service.HeaderService;
import org.byern.javalearning.lesson15.dip.bad.service.messaging.AbstractMessagingService;
import org.byern.javalearning.lesson15.dip.bad.service.messaging.FooterableMessagingService;
import org.byern.javalearning.lesson15.dip.bad.service.messaging.HeaderableMessagingService;
import org.byern.javalearning.lesson15.dip.bad.service.sender.SenderService;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class MessagingServiceWithFooterAndHeaderOnly extends AbstractMessagingService implements
        FooterableMessagingService, HeaderableMessagingService {

    private final FooterService footerService;
    private final HeaderService headerService;

    public MessagingServiceWithFooterAndHeaderOnly(SenderService senderService,
                                                   FooterService footerService,
                                                   HeaderService headerService) {
        super(senderService);
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
