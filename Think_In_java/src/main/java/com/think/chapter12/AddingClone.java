package com.think.chapter12;

import java.util.Vector;

/**
 * You must go through a few gyrations to add cloning to your own class
 */
class Int2 implements Cloneable {
    private int i;

    public Int2(int ii) {
        i = ii;
    }

    public void increment() {
        i++;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }

    @Override
    protected Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}

class Int3 extends Int2 {

    private int j;

    public Int3(int ii) {
        super(ii);
    }
}

public class AddingClone {
    public static void main(String[] args) {
        Int2 x = new Int2(10);
        Int2 x2 = (Int2) x.clone();
        x2.increment();
        System.out.println("x = " + x + ", x2 = " + x2);
        Int3 x3 = new Int3(7);
        x3 = (Int3) x3.clone();

        Vector v = new Vector();
        for (int i = 0; i < 10; ++i) {
            v.addElement(new Int2(i));
        }

        System.out.println("v: " + v);
        Vector v2 = (Vector) v.clone();
        for (int i = 0; i < v.size(); ++i) {
            v2.setElementAt(((Int2) v2.elementAt(i)).clone(), i);
        }

        System.out.println("v: " + v);
        System.out.println("v2 : " + v2);
    }
}
