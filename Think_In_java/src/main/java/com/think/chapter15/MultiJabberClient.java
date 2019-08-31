package com.think.chapter15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Client that tests the MultiJabberServer by starting up multiple clients
 */
class JabberClientThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private static int counter = 0;
    private int id = counter++;
    private static int threadCount = 0;

    public static int threadCount() {
        return threadCount;
    }

    public JabberClientThread(InetAddress addr) {
        System.out.println("Making client " + id);
        threadCount++;
        try {
            socket = new Socket(addr, MultiJabberServer.PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            start();
        } catch (IOException e) {
            try {
                socket.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 25; ++i) {
                out.println("Client " + id + " : " + i);
                String str = in.readLine();
                System.out.println(str);
            }
            out.println("END");
        } catch (IOException e) {

        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            threadCount--;
        }
    }
}

public class MultiJabberClient {
    private static final int MAX_THREADS = 10;

    public static void main(String[] args) throws IOException, InterruptedException {
        InetAddress addr = InetAddress.getByName(null);
        while (true) {
            if (JabberClientThread.threadCount() < MAX_THREADS) {
                new JabberClientThread(addr);
                Thread.currentThread().sleep(100);
            }
        }
    }
}
