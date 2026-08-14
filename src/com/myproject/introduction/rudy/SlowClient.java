package com.myproject.introduction.rudy;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SlowClient {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8080;

    // Keep this small for the localhost lab.
    private static final int CONNECTIONS = 3;

    static void main(String[] args) {

        System.out.println("Starting localhost RUDY simulation...");

        for (int i = 1; i <= CONNECTIONS; i++) {

            final int clientId = i;

            Thread thread = new Thread(() -> {

                try {
                    runSlowConnection(clientId);
                } catch (Exception e) {
                    System.out.println(
                            "Client " + clientId +
                                    " stopped: " + e.getMessage()
                    );
                }

            }, "slow-client-" + clientId);

            thread.start();
        }
    }

    private static void runSlowConnection(int id)
            throws IOException, InterruptedException {

        try (Socket socket = new Socket(HOST, PORT)) {

            OutputStream out = socket.getOutputStream();

            String headers =
                    """
                            POST /upload HTTP/1.1\r
                            Host: localhost\r
                            Content-Length: 20\r
                            Content-Type: text/plain\r
                            Connection: close\r
                            \r
                            """;

            out.write(headers.getBytes(StandardCharsets.UTF_8));
            out.flush();

            System.out.println(
                    "Client " + id +
                            " connected and sent headers."
            );

            /*
             * Send the body very slowly.
             *
             * The server believes the request body is
             * 1,000,000 bytes, but we're only sending a
             * tiny amount at a time.
             */
            for (int i = 0; i < 20; i++) {

                out.write('A');
                out.flush();

                System.out.println(
                        "Client " + id +
                                " sent byte " + (i + 1)
                );

                Thread.sleep(1000);
            }

            System.out.println(
                    "Client " + id + " finished."
            );
        }
    }
}
