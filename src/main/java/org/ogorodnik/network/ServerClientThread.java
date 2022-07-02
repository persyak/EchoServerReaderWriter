package org.ogorodnik.network;

import java.io.*;
import java.net.Socket;

public class ServerClientThread extends Thread {
    private static final String LINE_END = "\n";
    Socket serverSocket;

    public ServerClientThread(Socket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(serverSocket.getOutputStream()))) {
            while (true) {
                String line = reader.readLine();
                String messageFromClient = "Echo " + line;
                writer.write(messageFromClient);
                writer.write(LINE_END);
                writer.flush();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
