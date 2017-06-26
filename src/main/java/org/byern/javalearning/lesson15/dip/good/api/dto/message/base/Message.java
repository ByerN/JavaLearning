package org.byern.javalearning.lesson15.dip.good.api.dto.message.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.byern.javalearning.lesson15.dip.good.api.dto.translation.Translatable;
import org.byern.javalearning.lesson15.dip.good.api.dto.translation.TranslatableItem;

/**
 * Created by krzyspo on 10/06/2017.
 */
@Getter
@Setter
@ToString
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