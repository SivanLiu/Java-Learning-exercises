package com.think.chapter15;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Tests the ChatterServer by starting multiple clients, echo of which sends datagrams
 */
public class ChatterClient extends Thread {
    private DatagramSocket s;
    private InetAddress hostAddress;
    private byte[] buf = new byte[1000];
    private DatagramPacket dp = new DatagramPacket(buf, buf.length);
    private int id;

    public ChatterClient(int identifier) {
        id = identifier;
        try {
            s = new DatagramSocket();
            hostAddress = InetAddress.getByName(null);
        } catch (UnknownHostException e) {
            System.out.println("Cannot find host");
            System.exit(1);
        } catch (SocketException e) {
            System.err.println("Cannot open socket");
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("ChatterClient starting");
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 25; ++i) {
                String outMessage = "Client # " + id + ", message # " + i;
                s.send(Dgram.toDatagram(outMessage, hostAddress, ChatterServer.INPORT));
                s.receive(dp);
                String rcvd = "Client # " + id + ", rcvd from " + dp.getAddress() + " , " + dp.getPort() + " : " + Dgram
                        .toString(dp);
                System.out.println(rcvd);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new ChatterClient(i).start();
        }
    }
}
