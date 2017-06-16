package org.byern.javalearning.lesson15.dip.good.impl.service.header;

import org.byern.javalearning.lesson15.dip.good.api.dto.message.base.Message;
import org.byern.javalearning.lesson15.dip.good.api.service.header.HeaderService;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class HeaderServiceImpl implements HeaderService {
    @Override
    public void addHeader(Message message) {
        System.out.println("Header added to " + message);

    }
}
