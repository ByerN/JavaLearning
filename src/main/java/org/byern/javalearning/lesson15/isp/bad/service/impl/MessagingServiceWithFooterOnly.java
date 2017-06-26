package org.byern.javalearning.lesson15.isp.bad.service.impl;

import org.byern.javalearning.lesson15.isp.bad.api.dto.Message;
import org.byern.javalearning.lesson15.isp.bad.service.*;
import org.byern.javalearning.lesson15.isp.bad.service.sender.SenderService;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class MessagingServiceWithFooterOnly extends MessagingService{

    private final FooterService footerService;

    public MessagingServiceWithFooterOnly(SenderService senderService,
                                          FooterService footerService) {
        super(senderService);
        this.footerService = footerService;
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

    }
}
