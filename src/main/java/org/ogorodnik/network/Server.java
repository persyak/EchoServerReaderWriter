package org.ogorodnik.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        //listen
        while (true) {
            try (Socket socket = serverSocket.accept();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String messageFromClient = "Echo " + line;
                    writer.write(messageFromClient + "\n");
                    writer.flush();
                }
            }
        }
    }
}
