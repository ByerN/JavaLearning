package org.byern.javalearning.lesson15.dip.good.impl.service.messaging;

import org.byern.javalearning.lesson15.dip.good.api.dto.message.base.Message;
import org.byern.javalearning.lesson15.dip.good.api.service.sender.SenderServiceManager;
import org.byern.javalearning.lesson15.dip.good.api.service.translation.TranslationService;
import org.byern.javalearning.lesson15.dip.good.api.service.messaging.AbstractMessagingService;
import org.byern.javalearning.lesson15.dip.good.api.service.messaging.TranslatableMessagingService;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class MessagingServiceWithTranslationOnly extends AbstractMessagingService
        implements TranslatableMessagingService {

    private final TranslationService translationService;

    public MessagingServiceWithTranslationOnly(SenderServiceManager senderServiceManager,
                                               TranslationService translationService) {
        super(senderServiceManager);
        this.translationService = translationService;
    }

    @Override
    public void translate(Message message) {
        translationService.translate(message);
    }

}
