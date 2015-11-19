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

package ru.adduxa.inetApps.Lab5.Server;

import java.io.*;
import java.net.*;
import java.util.ResourceBundle;

public class Server {
    static ResourceBundle resourceBundle;

    public static void main(String args[]) {
        resourceBundle = ResourceBundle.getBundle("ru.adduxa.inetApps.Lab5.locale");
        try {
            ServerSocket server = new ServerSocket();
            server.bind(new InetSocketAddress("localhost", 666));
            System.out.printf(resourceBundle.getString("server.started"), server.getLocalSocketAddress());

            while(true) {
                Socket socket = server.accept();
                System.out.printf(resourceBundle.getString("server.newConnection"), socket.getRemoteSocketAddress());
                ConnectionHandler handler = new ConnectionHandler(socket);
                new Thread(handler).start();
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
