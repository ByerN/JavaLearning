package org.byern.javalearning.lesson6.lsystem.core.view;

import org.byern.javalearning.lesson6.lsystem.core.dto.Line;

/**
 * Created by ByerN on 05.03.2017.
 */
public class LinePrinter {

    public static final String TRUE_PRINT_VALUE = "X";
    public static final String FALSE_PRINT_VALUE = " ";

    public void printLines(Line[] lines,
                           int viewportWidth,
                           int viewportHeight) {
        printArray(
                createArrayToPrint(
                        lines,
                        viewportWidth,
                        viewportHeight
                ),
                viewportWidth,
                viewportHeight
        );
    }

    public void printArray(boolean[][] arrayToPrint, int viewportWidth, int viewportHeight) {
        for (int y = 0; y < viewportHeight; y++) {
            for (int x = 0; x < viewportWidth; x++) {
                System.out.print(arrayToPrint[x][y] ? TRUE_PRINT_VALUE : FALSE_PRINT_VALUE);
            }
            System.out.println();
        }
    }

    public boolean[][] createArrayToPrint(Line[] lines,
                                          int viewportWidth,
                                          int viewportHeight) {
        boolean[][] arrayToPrint = new boolean[viewportWidth][viewportHeight];

        for (Line line : lines) {
            int startX = (int) Math.round(line.getStartPoint().getX());
            int startY = (int) Math.round(line.getStartPoint().getY());

            int endX = (int) Math.round(line.getEndPoint().getX());
            int endY = (int) Math.round(line.getEndPoint().getY());

            int pointerX = startX;
            int pointerY = startY;

            int yDiff = endY - startY;
            int xDiff = endX - startX;
            double angle = Math.atan2(yDiff, xDiff);
            double distance = Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));

            printToArray(arrayToPrint, pointerX, pointerY);
            for (int n = 0; n <= distance; n++) {
                pointerX = (int) (startX + Math.cos(angle) * n);
                pointerY = (int) (startY + Math.sin(angle) * n);
                printToArray(arrayToPrint, pointerX, pointerY);
            }
            printToArray(arrayToPrint, pointerX, pointerY);
        }
        return arrayToPrint;
    }

    public void printToArray(boolean[][] arrayToPrint, int pointerX, int pointerY) {
        if (pointerX >= 0 && pointerX < arrayToPrint.length &&
                pointerY >= 0 && pointerY < arrayToPrint[pointerX].length) {
            arrayToPrint[pointerX][pointerY] = true;
        }
    }

}
