package org.byern.javalearning.lesson15.isp.good.service.messaging.impl;

import org.byern.javalearning.lesson15.isp.good.api.dto.Message;
import org.byern.javalearning.lesson15.isp.good.service.*;
import org.byern.javalearning.lesson15.isp.good.service.messaging.*;
import org.byern.javalearning.lesson15.isp.good.service.sender.SenderService;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class BasicMessagingService extends AbstractMessagingService implements HeaderableMessagingService,
        FooterableMessagingService, PersonalizableMessagingService,
        TranslatableMessagingService{

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
