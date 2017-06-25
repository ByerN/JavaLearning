package org.byern.javalearning.lesson15.isp.good.service.messaging.impl;

import org.byern.javalearning.lesson15.isp.good.api.dto.Message;
import org.byern.javalearning.lesson15.isp.good.service.messaging.AbstractMessagingService;
import org.byern.javalearning.lesson15.isp.good.service.TranslationService;
import org.byern.javalearning.lesson15.isp.good.service.sender.SenderService;
import org.byern.javalearning.lesson15.isp.good.service.messaging.TranslatableMessagingService;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class MessagingServiceWithTranslationOnly extends AbstractMessagingService
        implements TranslatableMessagingService{

    private final TranslationService translationService;

    public MessagingServiceWithTranslationOnly(SenderService senderService,
                                               TranslationService translationService) {
        super(senderService);
        this.translationService = translationService;
    }

    @Override
    public void translate(Message message) {
        translationService.translate(message);
    }

}
