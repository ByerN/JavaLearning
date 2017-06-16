package org.byern.javalearning.lesson15.dip.good.impl.service.translation;

import org.byern.javalearning.lesson15.dip.good.api.dto.translation.Translatable;
import org.byern.javalearning.lesson15.dip.good.api.dto.translation.TranslatableItem;
import org.byern.javalearning.lesson15.dip.good.api.service.translation.TranslationService;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class TranslationServiceImpl implements TranslationService {

    @Override
    public void translate(Translatable message) {
        for(TranslatableItem item : message.getItemsToTranslate()) {
            item.setText(translate(item.getText()));

            System.out.println("Translation added for: " + message);
        }
    }

    private String translate(String text) {
        String translatedText = text; //translate
        return translatedText;
    }
}
