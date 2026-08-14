package com.myproject.introduction.rudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProtectedServer {

    private static final int PORT = 8080;

    private static final int MAX_WORKERS = 10;

    // Maximum HTTP request body allowed.
    private static final long MAX_BODY_SIZE = 10_000;

    // Maximum inactivity period while reading.
    private static final int READ_TIMEOUT = 5_000;

    static void main(String[] args) throws IOException {

        ExecutorService pool =
                Executors.newFixedThreadPool(MAX_WORKERS);

        try (ServerSocket serverSocket =
                     new ServerSocket(PORT)) {

            System.out.println(
                    "Protected server running on port " + PORT
            );

            while (true) {

                Socket socket = serverSocket.accept();

                /*
                 * If a read waits longer than 5 seconds
                 * without receiving data, SocketTimeoutException
                 * will be thrown.
                 */
                socket.setSoTimeout(READ_TIMEOUT);

                System.out.println(
                        "Accepted connection from "
                                + socket.getRemoteSocketAddress()
                );

                pool.submit(() -> handleClient(socket));
            }
        }
    }

    private static void handleClient(Socket socket) {

        String client =
                socket.getRemoteSocketAddress().toString();

        try (socket) {

            InputStream input =
                    socket.getInputStream();

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(input)
                    );

            long contentLength = readHeaders(reader);

            System.out.println(
                    "Declared body size: "
                            + contentLength
            );

            /*
             * Protection #1:
             * Reject excessively large bodies.
             */
            if (contentLength > MAX_BODY_SIZE) {

                System.out.println(
                        "REJECTED: body too large"
                );

                return;
            }

            /*
             * Protection #2:
             * Read the declared body size.
             */
            readBody(input, contentLength);

            System.out.println(
                    "Request completed: " + client
            );

        } catch (SocketTimeoutException e) {

            System.out.println(
                    "TIMEOUT: closing slow client "
                            + client
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "INVALID Content-Length: "
                            + client
            );

        } catch (IOException e) {

            System.out.println(
                    "Connection closed: "
                            + client
            );
        }
    }

    private static long readHeaders(
            BufferedReader reader
    ) throws IOException {

        String line;

        long contentLength = -1;

        while ((line = reader.readLine()) != null) {

            if (line.isEmpty()) {
                break;
            }

            System.out.println(
                    Thread.currentThread().getName()
                            + " -> " + line
            );

            String lower =
                    line.toLowerCase();

            if (lower.startsWith("content-length:")) {

                String value =
                        line.substring(
                                "content-length:".length()
                        ).trim();

                contentLength =
                        Long.parseLong(value);
            }
        }

        if (contentLength < 0) {
            throw new NumberFormatException(
                    "Missing Content-Length"
            );
        }

        return contentLength;
    }

    private static void readBody(
            InputStream input,
            long contentLength
    ) throws IOException {

        byte[] buffer = new byte[1024];

        long bytesRead = 0;

        System.out.println(
                Thread.currentThread().getName()
                        + " reading request body..."
        );

        while (bytesRead < contentLength) {

            int remaining =
                    (int) Math.min(
                            buffer.length,
                            contentLength - bytesRead
                    );

            int read =
                    input.read(
                            buffer,
                            0,
                            remaining
                    );

            if (read == -1) {

                System.out.println(
                        "INCOMPLETE request: "
                                + bytesRead
                                + "/"
                                + contentLength
                );

                return;
            }

            bytesRead += read;

            System.out.println(
                    Thread.currentThread().getName()
                            + " received "
                            + bytesRead
                            + "/"
                            + contentLength
            );
        }
    }
}
