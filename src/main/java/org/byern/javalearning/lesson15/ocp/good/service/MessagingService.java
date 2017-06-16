package org.byern.javalearning.lesson15.ocp.good.service;

import lombok.AllArgsConstructor;
import org.byern.javalearning.lesson15.ocp.good.constant.MessageType;
import org.byern.javalearning.lesson15.ocp.good.dto.Message;
import org.byern.javalearning.lesson15.ocp.good.service.sender.SenderService;
import org.byern.javalearning.lesson15.ocp.good.service.sender.SenderServiceManager;

/**
 * Created by krzyspo on 10/06/2017.
 */
@AllArgsConstructor
public class MessagingService {

    /*
     * Go to SenderServiceManagerImpl
     */

    private PersonalizationService personalizationService;
    private TranslationService translationService;
    private FooterService footerService;
    private HeaderService headerService;
    private SenderServiceManager senderServiceManager;


    public void sendMessage(Message message,
                            MessageType type){
        personalizationService.personalize(message);
        translationService.translate(message);
        footerService.addFooter(message);
        headerService.addHeader(message);
        senderServiceManager.getSender(message).send(message);
    }
}
