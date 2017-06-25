package org.byern.javalearning.lesson15.dip.bad.service.messaging.impl;

import org.byern.javalearning.lesson15.dip.bad.api.dto.Message;
import org.byern.javalearning.lesson15.dip.bad.service.TranslationService;
import org.byern.javalearning.lesson15.dip.bad.service.messaging.AbstractMessagingService;
import org.byern.javalearning.lesson15.dip.bad.service.messaging.TranslatableMessagingService;
import org.byern.javalearning.lesson15.dip.bad.service.sender.SenderService;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class MessagingServiceWithTranslationOnly extends AbstractMessagingService
        implements TranslatableMessagingService {

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
