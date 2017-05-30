package org.byern.javalearning.impl;

import org.byern.javalearning.MyEvent;
import org.byern.javalearning.resolver.MyChatEventVisitor;

/**
 * Created by ByerN on 29.05.2017.
 */
public class AuthorizedEvent implements MyEvent {

    @Override
    public void accept(MyChatEventVisitor visitor) {
        visitor.visit(this);
    }


}
