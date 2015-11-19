package ru.adduxa.inetApps.Lab5.Server;

import ru.adduxa.inetApps.Lab5.AnswerData;
import ru.adduxa.inetApps.Lab5.Form;
import ru.adduxa.inetApps.Lab5.RequestData;
import ru.adduxa.inetApps.Lab5.Vertex;

import java.io.*;
import java.net.*;

public class ConnectionHandler implements Runnable{
    private Socket socket;

    public ConnectionHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);

            RequestData requestData = (RequestData) ois.readObject();

            Form form = new Form(requestData.R);


            AnswerData answerData = new AnswerData();
            answerData.Contains = form.contains(new Vertex(requestData));

            oos.writeObject(answerData);

            ois.close();
            is.close();
            os.close();
            oos.close();
            socket.close();
            System.out.printf(Server.resourceBundle.getString("server.connectionClosed"), socket.getRemoteSocketAddress());
        }
        catch(IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
