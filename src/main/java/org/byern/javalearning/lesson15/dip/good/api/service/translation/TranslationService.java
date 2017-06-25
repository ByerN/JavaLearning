package org.byern.javalearning.lesson15.dip.good.api.service.translation;

import org.byern.javalearning.lesson15.dip.good.api.dto.translation.Translatable;

/**
 * Created by krzyspo on 10/06/2017.
 */
public interface TranslationService {
    void translate(Translatable message);
}
