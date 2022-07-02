package org.ogorodnik.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(3000)) {
            while (true) {
                Socket socket = serverSocket.accept();
                ServerClientThread serverClientThread = new ServerClientThread(socket);
                EXECUTOR_SERVICE.execute(serverClientThread);
            }
        }
    }
}
