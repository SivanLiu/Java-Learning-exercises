package com.think.chapter12;

class MyObject implements Cloneable {
    int i;

    MyObject(int ii) {
        this.i = ii;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("MyObject can't clone");
        }
        return o;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

public class LocalCopy {
    static MyObject g(MyObject v) {
        v.i++;
        return v;
    }

    static MyObject f(MyObject v) throws CloneNotSupportedException {
        v = (MyObject) v.clone();
        v.i++;
        return v;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        MyObject a = new MyObject(11);
        MyObject b = g(a);
        if (a == b) {
            System.out.println("a == b");
        } else {
            System.out.println("a!=b");
        }

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        MyObject c = new MyObject(47);
        MyObject d = f(c);
        if (c == d) {
            System.out.println("c == d");
        } else {
            System.out.println("c != d");
        }

        System.out.println("c = " + c);
        System.out.println("d = " + d);
    }
}
