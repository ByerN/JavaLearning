package org.byern.javalearning.lesson15.lsp.bad.service;

import org.byern.javalearning.lesson15.lsp.bad.dto.Message;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class TranslationService {

    /*
     * This bad example shows Liskov substitution
     * principle violation. We cannot use SmsMessage
     * type because it doesn't have an subject and
     * getSubject method throws UnsupportedOperationException.
     *
     */

    public void translate(Message message) {
        message.setBody(translate(message.getBody()));
        message.setSubject(translate(message.getSubject()));
    }

    private String translate(String text) {
        String translatedText = text; //translate
        return translatedText;
    }
}
