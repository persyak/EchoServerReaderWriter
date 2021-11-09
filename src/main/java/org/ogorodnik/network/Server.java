package org.ogorodnik.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        //listen
        while (true) {
            char[] serverBuffer = new char[50];
            try (Socket socket = serverSocket.accept();
                 Reader reader = new InputStreamReader(socket.getInputStream());
                 Writer writer = new OutputStreamWriter(socket.getOutputStream())) {
                int serverCount = reader.read(serverBuffer);
                String messageFromClient = "Echo " + new String(serverBuffer, 0, serverCount);
                writer.write(messageFromClient);
            }
        }
    }
}
