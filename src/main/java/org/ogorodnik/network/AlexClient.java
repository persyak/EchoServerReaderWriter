package org.ogorodnik.network;

import java.io.*;
import java.net.Socket;

public class AlexClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 3000);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader readerIn = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Insert word or phrase from a keyboard");
            String input;
            while (!("finish".equals(input = readerIn.readLine().toLowerCase()))) {
                writer.write(input + '\n');
                writer.flush();
                System.out.println(reader.readLine());
                System.out.println("Insert another word or phrase from a keyboard or word 'finish' to end connection");
            }
        }
    }
}
