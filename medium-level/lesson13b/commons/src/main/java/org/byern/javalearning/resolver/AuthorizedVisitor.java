package org.byern.javalearning.resolver;

import org.byern.javalearning.impl.AuthorizedEvent;

/**
 * Created by ByerN on 29.05.2017.
 */
public interface AuthorizedVisitor {

    void visit(AuthorizedEvent event);

}
