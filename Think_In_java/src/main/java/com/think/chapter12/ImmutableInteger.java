package com.think.chapter12;

import java.util.Vector;

/**
 * The Integer class can not be changed
 */
class IntValue {
    int n;

    IntValue(int x) {
        n = x;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}

public class ImmutableInteger {
    public static void main(String[] args) {
        Vector vector = new Vector();
        for (int i = 0; i < 10; ++i) {
            vector.addElement(new IntValue(i));
        }

        System.out.println(vector);
        for (int i = 0; i < vector.size(); ++i) {
            ((IntValue) vector.elementAt(i)).n++;
        }

        System.out.println(vector);
    }
}
