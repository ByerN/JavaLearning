package org.byern.javalearning.lesson15.isp.bad.service.impl;

import org.byern.javalearning.lesson15.isp.bad.api.dto.Message;
import org.byern.javalearning.lesson15.isp.bad.service.FooterService;
import org.byern.javalearning.lesson15.isp.bad.service.HeaderService;
import org.byern.javalearning.lesson15.isp.bad.service.MessagingService;
import org.byern.javalearning.lesson15.isp.bad.service.TranslationService;
import org.byern.javalearning.lesson15.isp.bad.service.sender.SenderService;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class MessagingServiceWithTranslationOnly extends MessagingService{

    private final TranslationService translationService;

    public MessagingServiceWithTranslationOnly(SenderService senderService,
                                               TranslationService translationService) {
        super(senderService);
        this.translationService = translationService;
    }

    @Override
    public void personalize(Message message) {
    }

    @Override
    public void translate(Message message) {
        translationService.translate(message);
    }

    @Override
    public void addFooter(Message message){
    }

    @Override
    public void addHeader(Message message) {

    }
}
