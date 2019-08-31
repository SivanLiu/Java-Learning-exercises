package com.think.chapter15;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class WhoAmI {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress a = InetAddress.getByName(null);
        System.out.println(a);
    }
}
