package org.byern.javalearning.lesson15.dip.bad.api.dto;

import org.byern.javalearning.lesson15.dip.bad.api.translation.TranslatableItem;

import java.util.Arrays;
import java.util.List;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class EmailMessage extends Message {

    protected TranslatableItem subject;

    public EmailMessage(String subject,
                        String body,
                        String from,
                        String to) {
        super(body, from, to);
        this.subject = new TranslatableItem(subject);
    }

    @Override
    public List<TranslatableItem> getItemsToTranslate() {
        return Arrays.asList(subject, body);
    }
}
