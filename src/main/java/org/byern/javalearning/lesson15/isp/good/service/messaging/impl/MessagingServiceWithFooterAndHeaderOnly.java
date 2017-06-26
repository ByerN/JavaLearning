package org.byern.javalearning.lesson15.isp.good.service.messaging.impl;

import org.byern.javalearning.lesson15.isp.good.api.dto.Message;
import org.byern.javalearning.lesson15.isp.good.service.FooterService;
import org.byern.javalearning.lesson15.isp.good.service.HeaderService;
import org.byern.javalearning.lesson15.isp.good.service.messaging.*;
import org.byern.javalearning.lesson15.isp.good.service.sender.SenderService;

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
