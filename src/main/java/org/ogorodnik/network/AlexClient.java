package org.ogorodnik.network;

import java.io.*;
import java.net.Socket;

public class AlexClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 3000);

        try (Reader reader = new  BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            writer.write("Hello");
            writer.flush();
            char[] clientBuffer = new char[50];
            int clientCount = reader.read(clientBuffer);
            System.out.println(new String(clientBuffer, 0, clientCount));
        }
    }
}
