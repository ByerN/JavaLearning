package org.byern.javalearning.lesson15.isp.bad.service.impl;

import org.byern.javalearning.lesson15.isp.bad.api.dto.Message;
import org.byern.javalearning.lesson15.isp.bad.service.FooterService;
import org.byern.javalearning.lesson15.isp.bad.service.HeaderService;
import org.byern.javalearning.lesson15.isp.bad.service.MessagingService;
import org.byern.javalearning.lesson15.isp.bad.service.sender.SenderService;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class MessagingServiceWithFooterAndHeaderOnly extends MessagingService{

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
    public void personalize(Message message) {
    }

    @Override
    public void translate(Message message) {

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
