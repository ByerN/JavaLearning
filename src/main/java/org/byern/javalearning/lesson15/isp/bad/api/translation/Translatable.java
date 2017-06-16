package org.byern.javalearning.lesson15.isp.bad.api.translation;

import java.util.List;

/**
 * Created by krzyspo on 10/06/2017.
 */
public interface Translatable {

    List<TranslatableItem> getItemsToTranslate();
}
