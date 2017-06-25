package org.byern.javalearning.lesson15;

/**
 * Created by krzyspo on 09/06/2017.
 */
public class SingleResponsibilityLesson {

    /**
     * Single responsibility principle:
     *
     * "a class should have only a single responsibility
     * (i.e. only one potential change in the software's specification
     * should be able to affect the specification
     * of the class)"
     *
     * This rule has been created to minimalize changes
     * impact and stick close to semantics.
     *
     * Class/module shouldn't be designed to do too many things.
     * The best solution is when it's created to have only one role.
     *
     * For example:
     * -we are creating the program that is sending messages via
     *  many different ways.
     *  If we create only one class that will receive, process message
     *  (for example translate it's elements to other languages),
     *  send it as email, we will have to change this class if one of this
     *  functionality change.
     *  It leads to major impact on other functionality that are
     *  not strictly connected with the changed one and is causing
     *  major regression risk in many different scopes.
     *
     *  Solution:
     *  It's much better to create different classes that covers limited scope.
     *  This way we will be able to leverage impact of changes and
     *  risk of potential regression.
     *  Other profit of this solution is that we will have code
     *  that documents itself (clean-code)
     *
     *
     */
}
