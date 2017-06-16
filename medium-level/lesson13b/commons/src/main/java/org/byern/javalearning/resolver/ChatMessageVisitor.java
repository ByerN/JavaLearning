package org.byern.javalearning.resolver;

import org.byern.javalearning.impl.ChatMessageEvent;

/**
 * Created by ByerN on 29.05.2017.
 */
public interface ChatMessageVisitor {

    void visit(ChatMessageEvent event);

}
