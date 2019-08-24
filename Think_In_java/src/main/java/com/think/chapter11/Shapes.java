package com.think.chapter11;

import java.util.Enumeration;
import java.util.Vector;

interface Shape {
    void draw();
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square.draw()");
    }
}

class Triangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Triangle.draw()");
    }
}

public class Shapes {
    public static void main(String[] args) {
        Vector s = new Vector();
        s.addElement(new Circle());
        s.addElement(new Square());
        s.addElement(new Triangle());
        Enumeration e = s.elements();
        while (e.hasMoreElements()){
            ((Shape)e.nextElement()).draw();
        }
    }
}
