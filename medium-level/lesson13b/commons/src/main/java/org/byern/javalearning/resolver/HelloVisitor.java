package org.byern.javalearning.resolver;

import org.byern.javalearning.impl.HelloEvent;

/**
 * Created by ByerN on 29.05.2017.
 */
public interface HelloVisitor {

    void visit(HelloEvent event);

}
