package org.byern.javalearning.lesson15.lsp.bad.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by krzyspo on 10/06/2017.
 */
@AllArgsConstructor
@Setter
public abstract class Message{
    protected String subject;
    protected String body;
    private String from;
    private String to;

    public abstract String getBody();
    public abstract String getSubject();

}