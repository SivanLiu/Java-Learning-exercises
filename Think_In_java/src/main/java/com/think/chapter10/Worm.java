package com.think.chapter10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Demonstrates object serializatioin in java
 */
class Data implements Serializable {
    private int i;

    Data(int x) {
        i = x;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

public class Worm implements Serializable {
    private static int r() {
        return (int) (Math.random() * 10);
    }

    private Data[] d = { new Data(r()), new Data(r()), new Data(r()) };

    private Worm next;
    private char c;

    //Value of i == number of segments;
    Worm(int i, char x) {
        System.out.println("Worm constructor: " + i);
        c = x;
        if (--i > 0) {
            next = new Worm(i, (char) (x + 1));
        }
    }

    Worm() {
        System.out.println("Default constructor");
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(":" + c + "(");
        for (Data data : d) {
            s.append(data.toString());
        }
        s.append(")");
        if (next != null) {
            s.append(next.toString());
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Worm w = new Worm(6, 'a');
        System.out.println("W  = " + w);
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("worm.out"));
            out.writeObject("Worm storage");
            out.writeObject(w);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.out"));
            String s = (String) in.readObject();
            Worm w2 = (Worm) in.readObject();
            System.out.println(s + ", w2 = " + w2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bout);
            out.writeObject("Worm storage");
            out.writeObject(w);
            out.flush();
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
            String s = (String) in.readObject();
            Worm w3 = (Worm) in.readObject();
            System.out.println(s + ", w3 = " + w3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
