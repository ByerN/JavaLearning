package org.byern.javalearning.lesson6.lsystem.core.exception;

/**
 * Created by ByerN on 05.03.2017.
 */
public class RuleReadingException extends Exception {

    public RuleReadingException(String message) {
        super(message);
    }

    public RuleReadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
