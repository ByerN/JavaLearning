package org.byern.javalearning.lesson15.isp.bad.service.impl;

import org.byern.javalearning.lesson15.isp.bad.api.dto.Message;
import org.byern.javalearning.lesson15.isp.bad.service.*;
import org.byern.javalearning.lesson15.isp.bad.service.sender.SenderService;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class BasicMessagingService extends MessagingService{

    private final PersonalizationService personalizationService;
    private final TranslationService translationService;
    private final FooterService footerService;
    private final HeaderService headerService;

    public BasicMessagingService(SenderService senderService,
                                 PersonalizationService personalizationService,
                                 TranslationService translationService,
                                 FooterService footerService,
                                 HeaderService headerService) {
        super(senderService);
        this.personalizationService = personalizationService;
        this.translationService = translationService;
        this.footerService = footerService;
        this.headerService = headerService;
    }

    @Override
    public void personalize(Message message) {
        personalizationService.personalize(message);
    }

    @Override
    public void translate(Message message) {
        translationService.translate(message);
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
