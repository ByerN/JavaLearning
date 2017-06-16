package org.byern.javalearning.lesson15.isp.good.service;

import org.byern.javalearning.lesson15.isp.good.api.translation.Translatable;
import org.byern.javalearning.lesson15.isp.good.api.translation.TranslatableItem;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class TranslationService {

    /*
     * This good example fixed the problem with
     * LSP violation by correcting the inheritance of
     * Message classes.
     *
     * Now any class that implements Translatable interface
     * can be passed to the translate() method and there
     * developer doesn't matter about the specific implementation
     * anymore.
     */

    public void translate(Translatable message) {
        for(TranslatableItem item : message.getItemsToTranslate()) {
            item.setText(translate(item.getText()));
        }
    }

    private String translate(String text) {
        String translatedText = text; //translate
        return translatedText;
    }
}
