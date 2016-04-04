package ru.adduxa.inetApps.Lab7;

public class Form {
    private final double lowerLimit;
    private final double upperLimit;
    private final float R;

    public Form(float r) {
        R = r;
        lowerLimit = -R/2;
        upperLimit = R/2;
    }

    public boolean contains(Vertex vertex) {
        return vertex.getX() >= lowerLimit && vertex.getX() <= upperLimit && vertex.getY() <= upper(vertex.getX()) && vertex.getY() >= lower(vertex.getX());
    }

    public double upper(double x) {
        if (x < 0) {
            return 0;
        } else {
            return R;
        }
    }
    public double lower(double x) {
        if (x <= 0) {
            return -x - R/2;
        } else {
            return -Math.sqrt(Math.pow(R/2, 2) - Math.pow(x, 2));
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
