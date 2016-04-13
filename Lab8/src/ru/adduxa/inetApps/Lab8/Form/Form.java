package ru.adduxa.inetApps.Lab8.Form;

public class Form {
    private final double lowerLimit;
    private final double upperLimit;
    private final float R;

    public Form(float r) {
        R = r;
        lowerLimit = -R;
        upperLimit = R/2;
    }

    public boolean contains(Vertex vertex) {
        return vertex.getX() >= lowerLimit && vertex.getX() <= upperLimit && vertex.getY() <= upper(vertex.getX()) && vertex.getY() >= lower(vertex.getX());
    }

    public double upper(double x) {
        if (x < 0) {
            if(x >= -R/2) {
                return Math.sqrt(Math.pow(R / 2, 2) - Math.pow(x, 2));
            } else {
                return 0;
            }
        } else {
            return -2*x + R;
        }
    }
    public double lower(double x) {
        if (x <= 0) {
            return -R;
        } else {
            return 0;
        }
    }

    public double getLowerLimit() {
        return lowerLimit;
    }

    public double getUpperLimit() {
        return upperLimit;
    }

    public float getR() {
        return R;
    }
}
