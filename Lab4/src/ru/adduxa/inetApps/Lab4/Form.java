package ru.adduxa.inetApps.Lab4;

class Form {
    private final double lowerLimit;
    private final double upperLimit;
    private final float R;

    public Form(float r) {
        R = r;
        lowerLimit = -R;
        upperLimit = R;
    }

    public int contains(Vertex vertex) {
        return vertex.getX() >= lowerLimit && vertex.getX() <= upperLimit && vertex.getY() <= upper(vertex.getX()) && vertex.getY() >= lower(vertex.getX()) ? 1 : 0;
    }

    public double upper(double x) {
        if (x <= 0) return Math.sqrt(Math.pow(R, 2) - Math.pow(x, 2));
        else return R/2;
    }
    public double lower(double x) {
        if (x < 0) {
            return 0;
        } else if(x <= R/2){
            return 2 * x - R;
        } else return 0;
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
