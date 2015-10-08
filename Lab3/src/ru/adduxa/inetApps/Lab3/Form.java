package ru.adduxa.inetApps.Lab3;

public class Form {
    private float R;

    public Form(float r) {
        R = r;
    }

    public int Contains(Vertex vertex) {
        return vertex.X >= -R && vertex.X <= R / 2 && vertex.Y <= upper(vertex.X) && vertex.Y >= lower(vertex.X) ? 1 : 0;
    }

    private double upper(double x) {
        return x < 0 ? Math.sqrt(Math.pow(R, 2) - Math.pow(x, 2)) : R;
    }
    private double lower(double x) {
        return x <= 0 ? -0.5 * x - R / 2 : 0;
    }

}
