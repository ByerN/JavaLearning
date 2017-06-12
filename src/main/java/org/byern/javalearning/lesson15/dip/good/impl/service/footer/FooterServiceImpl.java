package org.byern.javalearning.lesson15.dip.good.impl.service.footer;

import org.byern.javalearning.lesson15.dip.good.api.dto.message.base.Message;
import org.byern.javalearning.lesson15.dip.good.api.service.footer.FooterService;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class FooterServiceImpl implements FooterService {
    @Override
    public void addFooter(Message message) {
        System.out.println("Footer added to " + message);
    }
}
