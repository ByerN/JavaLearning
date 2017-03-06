package org.byern.javalearning.lesson6.lsystem.tree.constant;

/**
 * Created by ByerN on 05.03.2017.
 */
public enum RuleAction {
    DRAW_LINE('F'),
    DRAW_LINE_END_AS_LEAF('f'),
    PUSH_POSITION('['),
    POP_POSITION(']'),
    TURN_LEFT('-', 25.7),
    TURN_RIGHT('+', 25.7);

    private final char symbol;
    private final double[] parameters;

    RuleAction(char symbol, double... parameters) {
        this.symbol = symbol;
        this.parameters = parameters;
    }

    public static RuleAction getBySymbol(char symbol) {
        RuleAction result = null;

        for (RuleAction action : RuleAction.values()) {
            if (action.getSymbol() == symbol) {
                result = action;
                break;
            }
        }

        return result;
    }

    public char getSymbol() {
        return symbol;
    }

    public double[] getParameters() {
        return parameters;
    }
}