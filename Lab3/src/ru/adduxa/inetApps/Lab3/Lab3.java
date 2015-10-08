package ru.adduxa.inetApps.Lab3;

import java.io.IOException;
import java.util.ListIterator;
import java.util.Vector;

public class Lab3 {
    private static final float DefaultR = 5f;
    public static void main(String[] args) throws IOException {

        float R = 0;
        boolean done = false;
        do {
            System.out.printf("Введите R: [%.0f] ", DefaultR);
            String str = System.console().readLine();
            if(str.isEmpty()) {
                R = DefaultR;
                done = true;
            } else {
                try {
                    R = new Float(str);
                    if(R > 0) {
                        done = true;
                    } else {
                        System.out.println("Некорректное значение! Ожидается ввод вещественного положительного числа");
                    }
                } catch(Exception E) {
                    System.out.println("Некорректное значение! Ожидается ввод вещественного положительного числа");
                }
            }
        } while(!done);

        Form S = new Form(R);

        Vector<Vertex> test = new Vector<>();
        test.add(new Vertex(1, 1));
        test.add(new Vertex(0, 0));
        test.add(new Vertex(2, 0));
        test.add(new Vertex(4, -4));
        test.add(new Vertex(-3, 3));
        test.add(new Vertex(5, 5));
        test.add(new Vertex(-4, -3));
        test.add(new Vertex(2, 0));
        test.add(new Vertex(-3, -1));

        ListIterator<Vertex> iterator = test.listIterator();

        do {
            Vertex current = iterator.next();
            if(S.contains(current) == 1) {
                System.out.printf("%.0f, %.0f%n", current.X, current.Y);
            }
        } while(iterator.hasNext());
    }
}
