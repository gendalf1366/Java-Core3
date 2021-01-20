package ru.geekbrains.abc;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionExecutorService {
    private final Socket socket;
    ExecutorService executorService;
    private final TCPConnectionListener eventListener;
    private final BufferedReader in;
    private final BufferedWriter out;

    public ConnectionExecutorService(TCPConnectionListener eventListener, String ipAddr, int port) throws IOException {
        this(eventListener, new Socket(ipAddr, port));
    }

    public ConnectionExecutorService(TCPConnectionListener eventListener, Socket socket) throws IOException {
        this.eventListener = eventListener;
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream(), Charset.forName("UTF-8")));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), Charset.forName("UTF-8")));
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    eventListener.onConnectionReady(ConnectionExecutorService.this);
                    while (!executorService.isShutdown()) {
                        eventListener.onReceiveString(ConnectionExecutorService.this, in.readLine());
                    }
                } catch (IOException e) {
                    eventListener.onException(ConnectionExecutorService.this, e);
                } finally {
                    eventListener.onDisconnect(ConnectionExecutorService.this);
                }
            }
        });
        executorService.shutdown();
    }

    public synchronized void sendString(String value) {
        try {
            out.write(value + "\r\n");
            out.flush();
        } catch (IOException e) {
            eventListener.onException(ConnectionExecutorService.this, e);
        }
    }

    public synchronized void disconnect() {
        executorService.shutdown();
        try {
            socket.close();
        } catch (IOException e) {
            eventListener.onException(ConnectionExecutorService.this, e);
        }
    }

    @Override
    public String toString() {
        return "TCPConnection: " + socket.getInetAddress() + ": " + socket.getPort();
    }
}
