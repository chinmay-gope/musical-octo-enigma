package com.myproject.introduction.rudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VulnerableServer {

    private static final int PORT = 8080;
    private static final int MAX_WORKERS = 10;

    static void main(String[] args) throws IOException {

        ExecutorService pool =
                Executors.newFixedThreadPool(MAX_WORKERS);

        try (ServerSocket serverSocket =
                     new ServerSocket(PORT)) {

            System.out.println(
                    "Vulnerable server running on port " + PORT
            );

            while (true) {

                Socket socket = serverSocket.accept();

                System.out.println(
                        "Accepted connection from " +
                                socket.getRemoteSocketAddress()
                );

                pool.submit(() -> handleClient(socket));
            }
        }
    }

    private static void handleClient(Socket socket) {

        String client =
                socket.getRemoteSocketAddress().toString();

        System.out.println(
                "Handling client: " + client
        );

        try (
                socket;
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        socket.getInputStream()
                                )
                        )
        ) {

            String line;

            /*
             * Read HTTP headers.
             */
            while ((line = reader.readLine()) != null) {

                if (line.isEmpty()) {
                    break;
                }

                System.out.println(
                        Thread.currentThread().getName()
                                + " -> " + line
                );
            }

            System.out.println(
                    Thread.currentThread().getName()
                            + " waiting for request body..."
            );

            /*
             * The client declared:
             *
             * Content-Length: 1000000
             *
             * but sends data very slowly.
             *
             * This worker therefore remains occupied
             * waiting for input.
             */
            while (reader.read() != -1) {
                // Process request body.
            }

            System.out.println(
                    "Request completed: " + client
            );

        } catch (IOException e) {

            System.out.println(
                    "Connection closed: " + client
            );
        }
    }
}
