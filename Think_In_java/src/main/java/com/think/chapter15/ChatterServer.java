package com.think.chapter15;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * A server that echoes datagrams
 */
public class ChatterServer {
    public static final int INPORT = 1711;
    private byte[] buf = new byte[1000];
    private DatagramPacket dp = new DatagramPacket(buf, buf.length);
    private DatagramSocket socket;

    public ChatterServer() {
        try {
            socket = new DatagramSocket(INPORT);
            System.out.println("Server started");
            while (true) {
                socket.receive(dp);
                String rcvd = Dgram.toString(dp) + ", from address: " + dp.getAddress() + ", port:" + dp.getPort();
                System.out.println(rcvd);
                String echoString = "Echoed: " + rcvd;
                DatagramPacket echo = Dgram.toDatagram(echoString, dp.getAddress(), dp.getPort());
                socket.send(echo);
            }
        } catch (SocketException e) {
            System.out.println("Can not open socket");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Communication error");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatterServer();
    }
}
