package org.byern.javalearning.lesson15.isp.good.api.dto;

import org.byern.javalearning.lesson15.isp.good.api.translation.Translatable;
import org.byern.javalearning.lesson15.isp.good.api.translation.TranslatableItem;

/**
 * Created by krzyspo on 10/06/2017.
 */
public abstract class Message implements Translatable {
    protected TranslatableItem body;
    private String from;
    private String to;

    public Message(String body, String from, String to) {
        this.body = new TranslatableItem(body);
        this.from = from;
        this.to = to;
    }
}