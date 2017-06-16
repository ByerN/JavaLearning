package org.byern.javalearning.lesson15.isp.good.service.messaging.impl;

import org.byern.javalearning.lesson15.isp.good.api.dto.Message;
import org.byern.javalearning.lesson15.isp.good.service.FooterService;
import org.byern.javalearning.lesson15.isp.good.service.messaging.AbstractMessagingService;
import org.byern.javalearning.lesson15.isp.good.service.sender.SenderService;
import org.byern.javalearning.lesson15.isp.good.service.messaging.FooterableMessagingService;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class MessagingServiceWithFooterOnly extends AbstractMessagingService implements
        FooterableMessagingService{

    private final FooterService footerService;

    public MessagingServiceWithFooterOnly(SenderService senderService,
                                          FooterService footerService) {
        super(senderService);
        this.footerService = footerService;
    }

    @Override
    public void addFooter(Message message) {
        footerService.addFooter(message);
    }

}
