/**
 * Университет ИТМО
 * Кафедра вычислительной техники
 * Программирование интернет-приложений
 *
 * Лабораторная работа №5
 * Клиент-серверное приложение на Java
 * Вариант: 2015
 *
 * Выполнил:
 * студент II курса факультета КТиУ
 * Дьяков Андрей Александрович, группа P3200
 *
 * Преподаватель:
 * Гаврилов Антон Валерьевич
 *
 * Санкт-Петербург, 2015г.
 */

package ru.adduxa.inetApps.Lab5.Client;

import ru.adduxa.inetApps.Lab5.Form;
import ru.adduxa.inetApps.Lab5.Vertex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Client implements Runnable {
    static ResourceBundle resourceBundle;

    @Override
    public void run() {
        JFrame frame = new JFrame(resourceBundle.getString("frame.title"));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //Creating toolbar
        JPanel toolbarPanel = new JPanel();
        toolbarPanel.setLayout(new FlowLayout());

        JLabel xLabel = new JLabel("X: ");
        toolbarPanel.add(xLabel);
        Double[] xItems = {-3d, -2d, -1d, 0d, 1d, 2d, 3d};
        JComboBox<Double> x = new JComboBox<>(xItems);
        x.setSelectedIndex(4);
        toolbarPanel.add(x);

        JLabel yLabel = new JLabel("Y: ");
        toolbarPanel.add(yLabel);
        ArrayList<JCheckBox> yItems = new ArrayList<>();
        Double[] yValues = {-3d, -2d, -1d, 0d, 1d, 2d, 3d};
        for (Double value : yValues) {
            JCheckBox cb = new JCheckBox(String.valueOf(value));
            cb.setSelected(true);
            yItems.add(cb);
        }
        yItems.forEach(toolbarPanel::add);

        JLabel rLabel = new JLabel("R: ");
        toolbarPanel.add(rLabel);

        JSpinner rSpinner = new JSpinner(new SpinnerNumberModel(2, 0.1, 100, 0.1));
        toolbarPanel.add(rSpinner);

        JButton setButton = new JButton(resourceBundle.getString("frame.setButton"));
        toolbarPanel.add(setButton);

        panel.add(toolbarPanel, BorderLayout.NORTH);

        //Creating graph
        Form f = new Form((float)(double)rSpinner.getValue());
        Graphs graphPanel = new Graphs(f);
        graphPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point click = e.getPoint();
                Vertex ver = graphPanel.clickToVertex(click);
                graphPanel.addVertex(ver);
                try {
                    if(graphPanel.remoteContains(ver) == 1) {
                        VertexThread vt = new VertexThread(ver, graphPanel);
                        vt.start();
                    }
                } catch (IOException ignored) {}
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        panel.add(graphPanel, BorderLayout.CENTER);

        //Adding listeners
        rSpinner.addChangeListener(e -> graphPanel.setR((float)(double)rSpinner.getValue()));
        setButton.addActionListener(e -> yItems.forEach(y -> {
            if(y.isSelected()) {
                Vertex ver = new Vertex((Double)x.getSelectedItem(), Double.valueOf(y.getText()));
                graphPanel.addVertex(ver);
                try {
                    if(graphPanel.remoteContains(ver) == 1) {
                        VertexThread vt = new VertexThread(ver, graphPanel);
                        vt.start();
                    }
                } catch (IOException ignored) {}
            }
        }));

        //Configuring frame
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setSize(frame.getWidth(), 360);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        resourceBundle = ResourceBundle.getBundle("ru.adduxa.inetApps.Lab5.locale");
        Client se = new Client();
        SwingUtilities.invokeLater(se);
    }
}
