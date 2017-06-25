package org.byern.javalearning.lesson15.dip.good.impl.service.sender.base;

import org.byern.javalearning.lesson15.dip.good.api.service.sender.SenderService;
import org.byern.javalearning.lesson15.dip.good.api.service.sender.SenderServiceManager;
import org.byern.javalearning.lesson15.dip.good.api.dto.message.base.Message;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class SenderServiceManagerImpl implements SenderServiceManager {

    private static final Map<Class<? extends Message>, SenderService<? extends Message>> services = new HashMap<>();

    @Override
    public <T extends Message> void registerSender(Class<T> type,
                                                   SenderService<T> senderService) {
        services.put(type, senderService);
        System.out.println("Sender for type: " + type + " registered");
    }

    @Override
    public SenderService getSender(Message message){
        Class<? extends Message> type = message.getClass();
        System.out.println("Looking for sender type: " + type);
        if(services.containsKey(type)){
            System.out.println("Sender for type: " + type + " found");
            return services.get(type);
        } else {
            throw new IllegalArgumentException("Service unavailable");
        }
    }
}
