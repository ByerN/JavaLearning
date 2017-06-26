package org.byern.javalearning.resolver;

/**
 * Created by ByerN on 29.05.2017.
 */
public interface MyChatEventVisitor extends ChatMessageVisitor, HelloVisitor, RegisterVisitor, AuthorizedVisitor {
}
