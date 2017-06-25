package org.byern.javalearning.lesson15;

/**
 * Created by krzyspo on 10/06/2017.
 */
public class InterfaceSegregationLesson {

    /**
     * "many client-specific interfaces
     * are better than one general-purpose interface."
     *
     * One general interface makes developer to implement
     * methods in concrete classes even when they are not used
     * in this subtype.
     *
     * If there will be a case where some of the interface
     * methods are not related to the subtype, it means that
     * interface is too general and can be split into
     * few more specific ones.
     */
}
