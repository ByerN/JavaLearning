package org.byern.javalearning.resolver;

import org.byern.javalearning.impl.RegisterEvent;

/**
 * Created by ByerN on 29.05.2017.
 */
public interface RegisterVisitor {

    void visit(RegisterEvent event);

}
