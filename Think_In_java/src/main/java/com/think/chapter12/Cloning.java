package com.think.chapter12;

import java.util.Enumeration;
import java.util.Vector;

class Int {
    private int i;

    public Int(int ii) {
        i = ii;
    }

    public void increment() {
        i++;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

public class Cloning {
    public static void main(String[] args) {
        Vector v = new Vector();
        for (int i = 0; i < 10; i++) {
            v.addElement(new Int(i));
        }

        System.out.println("v: " + v);
        Vector v2 = (Vector) v.clone();
        for (Enumeration e = v2.elements(); e.hasMoreElements(); ) {
            ((Int) e.nextElement()).increment();
        }

        System.out.println("v: " + v);
    }
}
