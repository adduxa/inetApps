package ru.adduxa.inetApps.Lab4;

class VertexThread extends Thread{
    private final Vertex vertex;
    private final Graphs graphPanel;

    public VertexThread(Vertex vertex, Graphs graphPanel) {
        this.vertex = vertex;
        this.graphPanel = graphPanel;
    }

    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int t = 255; t >= 0; t--) {
            vertex.setAlpha(t);
            graphPanel.repaint();
            try {
                Thread.sleep(1000/256);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
