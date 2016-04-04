package ru.adduxa.inetApps.Lab7;

import java.awt.*;

public class Vertex {
    private final double x;
    private final double y;
    private Color color;

    public Vertex(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getAlpha() {
        return color.getAlpha();
    }

    public void setAlpha(int alpha) {
        color = new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
    }
}
