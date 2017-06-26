package org.byern.javalearning.lesson15.dip.good.api.dto.message;

import lombok.ToString;
import org.byern.javalearning.lesson15.dip.good.api.dto.message.base.Message;
import org.byern.javalearning.lesson15.dip.good.api.dto.translation.TranslatableItem;

import java.util.Arrays;
import java.util.List;

/**
 * Created by krzyspo on 10/06/2017.
 */
@ToString(callSuper = true)
public class SmsMessage extends Message {

    public SmsMessage(String body,
                      String from,
                      String to) {
        super(body, from, to);
    }

    @Override
    public List<TranslatableItem> getItemsToTranslate() {
        return Arrays.asList(body);
    }
}
