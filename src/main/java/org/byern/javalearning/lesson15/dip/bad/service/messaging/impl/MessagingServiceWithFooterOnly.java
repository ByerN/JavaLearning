package org.byern.javalearning.lesson15.dip.bad.service.messaging.impl;

import org.byern.javalearning.lesson15.dip.bad.api.dto.Message;
import org.byern.javalearning.lesson15.dip.bad.service.FooterService;
import org.byern.javalearning.lesson15.dip.bad.service.messaging.AbstractMessagingService;
import org.byern.javalearning.lesson15.dip.bad.service.messaging.FooterableMessagingService;
import org.byern.javalearning.lesson15.dip.bad.service.sender.SenderService;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class MessagingServiceWithFooterOnly extends AbstractMessagingService implements
        FooterableMessagingService {

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
