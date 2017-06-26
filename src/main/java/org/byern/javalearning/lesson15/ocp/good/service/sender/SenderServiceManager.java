package org.byern.javalearning.lesson15.ocp.good.service.sender;

import org.byern.javalearning.lesson15.ocp.good.constant.MessageType;
import org.byern.javalearning.lesson15.ocp.good.dto.Message;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class SenderServiceManager {

    /*
     * This good example gets rid of violating
     * open-closed principle. Manager class
     * has been added for better sending services management.
     * SenderService has been turned into abstract class,
     * logic od sender dispatching has been moved to manager
     * and now there is no need of modification of existing units.
     *
     * Adding new type of message will affect by creating new
     * sender subtype and inject it into the manager
     * (for example via dependeny injection)
     *
     */

    private static final Map<Class<? extends Message>, SenderService<? extends Message>> services = new HashMap<>();

    public <T extends Message> void registerSender(Class<T> type,
                                   SenderService<T> senderService) {
        services.put(type, senderService);
    }

    public SenderService getSender(Message message){
        Class<? extends Message> type = message.getClass();
        if(services.containsKey(type)){
            return services.get(type);
        } else {
            throw new IllegalArgumentException("Service unavailable");
        }
    }
}
