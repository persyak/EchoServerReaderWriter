package org.ogorodnik.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final static String LINE_END = "\n";

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(3000)) {

            //listen
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                    while (true) {
                        String line = reader.readLine();
                        String messageFromClient = "Echo " + line;
                        writer.write(messageFromClient);
                        writer.write(LINE_END);
                        writer.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
