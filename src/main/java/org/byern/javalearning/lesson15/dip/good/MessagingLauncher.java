package org.byern.javalearning.lesson15.dip.good;

import org.byern.javalearning.lesson15.dip.good.api.dto.message.EmailMessage;
import org.byern.javalearning.lesson15.dip.good.api.dto.message.base.Message;
import org.byern.javalearning.lesson15.dip.good.api.service.messaging.AbstractMessagingService;
import org.byern.javalearning.lesson15.dip.good.api.service.messaging.MessagingServiceFunctionality;
import org.byern.javalearning.lesson15.dip.good.api.service.messaging.filter.MessageFilter;
import org.byern.javalearning.lesson15.dip.good.impl.service.footer.FooterServiceImpl;
import org.byern.javalearning.lesson15.dip.good.impl.service.header.HeaderServiceImpl;
import org.byern.javalearning.lesson15.dip.good.impl.service.messaging.BasicMessagingService;
import org.byern.javalearning.lesson15.dip.good.impl.service.personalisation.PersonalizationServiceImpl;
import org.byern.javalearning.lesson15.dip.good.impl.service.sender.EmailSenderImpl;
import org.byern.javalearning.lesson15.dip.good.impl.service.sender.SmsSenderImpl;
import org.byern.javalearning.lesson15.dip.good.impl.service.sender.base.SenderServiceManagerImpl;
import org.byern.javalearning.lesson15.dip.good.impl.service.translation.TranslationServiceImpl;
import org.byern.javalearning.lesson15.dip.good.api.dto.message.SmsMessage;

/**
 * Created by krzyspo on 11/06/2017.
 */
public class MessagingLauncher {

    public static void main(String[] args) {
        SenderServiceManagerImpl senderServiceManager = new SenderServiceManagerImpl();
        senderServiceManager.registerSender(EmailMessage.class, new EmailSenderImpl());
        senderServiceManager.registerSender(SmsMessage.class, new SmsSenderImpl());
        AbstractMessagingService messagingService = new BasicMessagingService(
                senderServiceManager,
                new PersonalizationServiceImpl(),
                new TranslationServiceImpl(),
                new FooterServiceImpl(),
                new HeaderServiceImpl()
        );
        messagingService.getFilters().add(
                new MessageFilter() {
                    @Override
                    public boolean isAcceptable(MessagingServiceFunctionality messagingServiceFunctionality,
                                                Message message) {
                        return message.getFrom().equals("me");
                    }

                    @Override
                    public void doFilter(MessagingServiceFunctionality messagingServiceFunctionality, Message message) {
                        message.setFrom("ByerN");
                    }
                }
        );
        messagingService.sendMessage(
                new SmsMessage(
                        "Hi!",
                        "me",
                        "you"
                )
        );
    }

}
