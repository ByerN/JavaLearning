package org.byern.javalearning.lesson6.lsystem.core.dto;

/**
 * Created by ByerN on 06.03.2017.
 */
public class Frame {
    private double x;
    private double y;
    private double angle;

    public Frame(double x, double y, double angle) {
        this.x = x;
        this.y = y;
        this.angle = angle;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
}