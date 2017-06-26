package org.byern.javalearning.lesson15.srp.good.service;

import lombok.AllArgsConstructor;
import org.byern.javalearning.lesson15.srp.good.constant.MessageType;
import org.byern.javalearning.lesson15.srp.good.dto.Message;

/**
 * Created by krzyspo on 10/06/2017.
 */
@AllArgsConstructor
public class MessagingService {

    /*
     * In this good example if we would like to change
     * one of the sending process steps, we will have to
     * rewrite only the class responsible for this process.
     *
     * We can also swap implementation of one specific
     * step.
     *
     */

    private PersonalizationService personalizationService;
    private TranslationService translationService;
    private FooterService footerService;
    private HeaderService headerService;
    private SenderService senderService;


    public void sendMessage(Message message,
                            MessageType type){
        personalizationService.personalize(message);
        translationService.translate(message);
        footerService.addFooter(message);
        headerService.addHeader(message);
        senderService.sendViaSpecificRoute(message, type);
    }
}
