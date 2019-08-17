package com.think.chapter8;

import java.util.Vector;

/**
 * A type-conscious Vector
 */
class Gopher {
    private int gopherNumber;

    Gopher(int i) {
        gopherNumber = i;
    }

    void print(String msg) {
        if (msg != null) {
            System.out.println(msg);
        }

        System.out.println("Gopher number " + gopherNumber);
    }
}

class GopherTrap {
    static void caughtYa(Gopher gopher) {
        gopher.print("Caught one!");
    }
}

public class GopherVector {
    private Vector vector = new Vector();

    public void addElement(Gopher gopher) {
        vector.addElement(gopher);
    }

    public Gopher elementAt(int index) {
        return (Gopher) vector.elementAt(index);
    }

    public int size() {
        return vector.size();
    }

    public static void main(String[] args) {
        GopherVector gopherVector = new GopherVector();
        for (int i = 0; i < 3; i++) {
            gopherVector.addElement(new Gopher(i));
        }

        for (int i = 0; i < gopherVector.size(); ++i) {
            GopherTrap.caughtYa(gopherVector.elementAt(i));
        }
    }
}
