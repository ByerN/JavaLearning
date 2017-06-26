package org.byern.javalearning.lesson15.lsp.good.api.dto;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.byern.javalearning.lesson15.lsp.good.api.translation.Translatable;
import org.byern.javalearning.lesson15.lsp.good.api.translation.TranslatableItem;

/**
 * Created by krzyspo on 10/06/2017.
 */
public abstract class Message implements Translatable{
    protected TranslatableItem body;
    private String from;
    private String to;

    public Message(String body, String from, String to) {
        this.body = new TranslatableItem(body);
        this.from = from;
        this.to = to;
    }
}