package org.byern.javalearning.lesson15.ocp.good.dto;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class EmailMessage extends Message {
    public EmailMessage(String subject,
                        String body,
                        String from,
                        String to) {
        super(subject, body, from, to);
    }
}
