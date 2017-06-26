package org.byern.javalearning.lesson15.dip.good.impl.service.personalisation;

import org.byern.javalearning.lesson15.dip.good.api.dto.message.base.Message;
import org.byern.javalearning.lesson15.dip.good.api.service.personalisation.PersonalizationService;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class PersonalizationServiceImpl implements PersonalizationService {

    @Override
    public void personalize(Message message) {
        System.out.println("Personalization added to " + message);
    }
}
