package org.byern.javalearning.lesson6.lsystem.core.util;

import org.byern.javalearning.lesson6.lsystem.core.dto.Line;
import org.byern.javalearning.lesson6.lsystem.core.dto.Point;

import java.util.Arrays;

/**
 * Created by ByerN on 05.03.2017.
 */
public class LineUtils {

    private LineUtils() {
    }

    public static Line createLine(double x, double y, double angle, int lineLength) {
        double angleInRadians = Math.toRadians(angle);
        double newX = x + Math.cos(angleInRadians) * lineLength;
        double newY = y + Math.sin(angleInRadians) * lineLength;
        Point startPoint = new Point(x, y);
        Point endPoint = new Point(newX, newY);
        return new Line(startPoint, endPoint);
    }

    public static void scaleToSize(Line[] lines, int width, int height) {
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;
        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;

        for (Line line : lines) {
            Point[] points = new Point[]{line.getStartPoint(), line.getEndPoint()};
            for (Point point : points) {
                double x = point.getX();
                double y = point.getY();
                if (x > maxX) {
                    maxX = x;
                }
                if (x < minX) {
                    minX = x;
                }
                if (y > maxY) {
                    maxY = y;
                }
                if (y < minY) {
                    minY = y;
                }
            }
        }

        for (Line line : lines) {
            Point[] points = new Point[]{line.getStartPoint(), line.getEndPoint()};
            for (Point point : points) {
                point.setY(point.getY() - minY);
                point.setX(point.getX() - minX);
            }
        }

        /*
         * newX            pointX
         * -        =   -
         * maxWidth        maxX
         *
         * newX = (pointX * maxWidth )/(maxX - minX);
         * scaleX = maxWidth / (maxX - minX);
         */
        double scaleX = width / (maxX - minX);
        double scaleY = height / (maxY - minY);
        for (Line line : lines) {
            Point[] points = new Point[]{line.getStartPoint(), line.getEndPoint()};
            for (Point point : points) {
                point.setY(point.getY() * scaleY);
                point.setX(point.getX() * scaleX);
            }
        }
    }

    public static Line[] addLine(Line[] result, Line line) {
        result = Arrays.copyOf(result, result.length + 1);
        result[result.length - 1] = line;
        return result;
    }
}
