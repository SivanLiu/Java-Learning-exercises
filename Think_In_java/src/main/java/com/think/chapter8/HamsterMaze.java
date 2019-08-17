package com.think.chapter8;

import java.util.Enumeration;
import java.util.Vector;

class Hamster {
    private int hamsterNumber;

    Hamster(int i) {
        hamsterNumber = i;
    }

    @Override
    public String toString() {
        return "This is Hamster #" + hamsterNumber;
    }
}

class Printer {
    static void printAll(Enumeration enumeration) {
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement().toString());
        }
    }
}

public class HamsterMaze {

    public static void main(String[] args) {
        Vector vector = new Vector();
        for (int i = 0; i < 3; i++) {
            vector.addElement(new Hamster(i));
            Printer.printAll(vector.elements());
        }
    }
}
