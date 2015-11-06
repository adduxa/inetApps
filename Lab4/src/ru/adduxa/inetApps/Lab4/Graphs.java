package ru.adduxa.inetApps.Lab4;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Graphs extends JPanel {
    private Form form;
    private final int xSize = 300;
    private final int ySize = 300;
    private final int xCenter = xSize/2;
    private final int yCenter = ySize/2;
    private int xStart, xEnd;
    private final double graphScale = 0.75;
    private double formScale;
    private int[] xPoints, yPoints;

    private final ArrayList<Vertex> vertexes = new ArrayList<>();

    public Graphs(Form form) {
        this.form = form;
        double lowerLimit = form.getLowerLimit();
        double upperLimit = form.getUpperLimit();
        double maxLimit = Math.max(Math.abs(lowerLimit), Math.abs(upperLimit));
        formScale = graphScale*xSize/2/maxLimit;


        xStart = (int) (Math.ceil(lowerLimit*formScale));
        xEnd = (int) (Math.floor(upperLimit*formScale));

        xPoints = new int[(xEnd - xStart + 1)*2];
        yPoints = new int[(xEnd - xStart + 1)*2];

        for(int x = xStart; x <= xEnd; x++) {
            int i = x - xStart;
            xPoints[i] = xCenter + x;
            yPoints[i] = graphToPixelsY(form.upper(x/formScale));
        }
        for(int x = xEnd; x >= xStart; x--) {
            int i = xEnd - xStart + 1 + xEnd - x;
            xPoints[i] = xCenter + x;
            yPoints[i] = graphToPixelsY(form.lower(x/formScale));
        }
    }

    public void paintComponent(Graphics g) {
        g.setColor(new Color(253,255, 177));
        g.fillRect(0, 0, super.getWidth(), super.getHeight());

        g.setColor(new Color(15, 151, 28));
        g.fillPolygon(xPoints, yPoints, (xEnd - xStart + 1) * 2);

        vertexes.forEach(vertex -> {
            g.setColor(vertex.getColor());
            g.fillOval(graphToPixelsX(vertex.getX()) - 3, graphToPixelsY(vertex.getY()) - 3, 7, 7);

            g.setColor(new Color(0, 0, 0, vertex.getAlpha()));
            g.drawString(String.format("%.0f, %.0f%n", vertex.getX(), vertex.getY()), graphToPixelsX(vertex.getX()) + 5, graphToPixelsY(vertex.getY()));
        });

        g.setColor(new Color(0, 0, 0, 255));
        g.drawLine(0, yCenter, xSize, yCenter); //Ось X
        g.drawLine(xCenter, ySize, xCenter, 0); //Ось Y
        g.drawLine(xSize, yCenter, xSize - 5, yCenter - 2); //Стрелочка X
        g.drawLine(xSize, yCenter, xSize - 5, yCenter + 2); //Стрелочка X
        g.drawLine(xCenter, 0, xCenter - 2, 5); //Стрелочка Y
        g.drawLine(xCenter, 0, xCenter + 2, 5); //Стрелочка Y

        g.drawLine(graphToPixelsX(form.getR()), yCenter - 3, graphToPixelsX(form.getR()), yCenter + 3); //(R, 0)
        g.drawLine(graphToPixelsX(-form.getR()), yCenter - 3, graphToPixelsX(-form.getR()), yCenter + 3); //(-R, 0)
        g.drawLine(xCenter - 3, graphToPixelsY(form.getR()), xCenter + 3, graphToPixelsY(form.getR())); //(0, R)
        g.drawLine(xCenter - 3, graphToPixelsY(-form.getR()), xCenter + 3, graphToPixelsY(-form.getR())); //(0, -R)

        g.drawString("R", graphToPixelsX(form.getR()) - 4, yCenter + 15); //(R, 0)
        g.drawString("-R", graphToPixelsX(-form.getR()) - 4, yCenter + 15); //(-R, 0)
        g.drawString("R", xCenter - 14, graphToPixelsY(form.getR()) + 5); //(0, R)
        g.drawString("-R", xCenter - 17, graphToPixelsY(-form.getR()) + 5); //(0, -R)
    }

    public void addVertex(Vertex vertex) {
        vertex.setColor(form.contains(vertex) == 1 ? new Color(0,142,255, 255) : new Color(255,0,0, 255));
        vertexes.add(vertex);
        repaint();
    }

    private int graphToPixelsX(double graphX) {
        return xCenter + (int) Math.round(graphX*formScale);
    }

    private int graphToPixelsY(double graphY) {
        return yCenter + (int) -Math.round(graphY*formScale);
    }

    public void setR(float r) {
        form = new Form(r);double lowerLimit = form.getLowerLimit();
        double upperLimit = form.getUpperLimit();
        double maxLimit = Math.max(Math.abs(lowerLimit), Math.abs(upperLimit));
        formScale = graphScale*xSize/2/maxLimit;


        xStart = (int) (Math.ceil(lowerLimit*formScale));
        xEnd = (int) (Math.floor(upperLimit*formScale));

        xPoints = new int[(xEnd - xStart + 1)*2];
        yPoints = new int[(xEnd - xStart + 1)*2];

        for(int x = xStart; x <= xEnd; x++) {
            int i = x - xStart;
            xPoints[i] = xCenter + x;
            yPoints[i] = graphToPixelsY(form.upper(x/formScale));
        }
        for(int x = xEnd; x >= xStart; x--) {
            int i = xEnd - xStart + 1 + xEnd - x;
            xPoints[i] = xCenter + x;
            yPoints[i] = graphToPixelsY(form.lower(x/formScale));
        }
        repaint();
    }

    public Vertex clickToVertex(Point click) {
        return new Vertex((click.getX() - xCenter)/formScale,(click.getY() - xCenter)/-formScale);
    }
}
