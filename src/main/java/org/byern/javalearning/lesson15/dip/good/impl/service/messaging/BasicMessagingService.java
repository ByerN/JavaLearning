package org.byern.javalearning.lesson15.dip.good.impl.service.messaging;

import org.byern.javalearning.lesson15.dip.good.api.dto.message.base.Message;
import org.byern.javalearning.lesson15.dip.good.api.service.footer.FooterService;
import org.byern.javalearning.lesson15.dip.good.api.service.header.HeaderService;
import org.byern.javalearning.lesson15.dip.good.api.service.messaging.*;
import org.byern.javalearning.lesson15.dip.good.api.service.personalisation.PersonalizationService;
import org.byern.javalearning.lesson15.dip.good.api.service.sender.SenderServiceManager;
import org.byern.javalearning.lesson15.dip.good.api.service.translation.TranslationService;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class BasicMessagingService extends AbstractMessagingService implements HeaderableMessagingService,
        FooterableMessagingService, PersonalizableMessagingService,
        TranslatableMessagingService {

    private final PersonalizationService personalizationService;
    private final TranslationService translationService;
    private final FooterService footerService;
    private final HeaderService headerService;

    public BasicMessagingService(SenderServiceManager senderServiceManager,
                                 PersonalizationService personalizationService,
                                 TranslationService translationService,
                                 FooterService footerService,
                                 HeaderService headerService) {
        super(senderServiceManager);
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
