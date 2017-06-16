package org.byern.javalearning;

import org.byern.javalearning.resolver.MyChatEventVisitor;

import java.io.Serializable;

/**
 * Created by ByerN on 29.05.2017.
 */
public interface MyEvent extends Serializable {
    void accept(MyChatEventVisitor visitor);
}
