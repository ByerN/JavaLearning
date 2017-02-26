package org.byern.javalearning.lesson4.example.enumeration;

/**
 * Created by ByerN on 26.02.2017.
 */
public enum Move {
    UP('w', 0, -1),
    DOWN('s', 0, 1),
    LEFT('a', -1, 0),
    RIGHT('d', 1, 0);

    private final char key;
    private final int xDiff;
    private final int yDiff;

    Move(char key, int xDiff, int yDiff) {
        this.key = key;
        this.xDiff = xDiff;
        this.yDiff = yDiff;
    }

    public static Move getMoveByCharacter(char character) {
        Move result = null;
        for (Move move : Move.values()) {
            if (move.key == character) {
                result = move;
                break;
            }
        }
        return result;
    }

    public int getXDiff() {
        return xDiff;
    }

    public int getYDiff() {
        return yDiff;
    }
}