package com.think.chapter7.innerscopes;

interface Selector {
    boolean end();

    Object current();

    void next();
}

public class Sequence {
    private Object[] objects;

    private int next = 0;

    public Sequence(int size) {
        objects = new Object[size];
    }

    public void add(Object x) {
        if (next < objects.length) {
            objects[next] = x;
            next++;
        }
    }

    private class SSelector implements Selector {
        int i = 0;

        @Override
        public boolean end() {
            return i == objects.length;
        }

        @Override
        public Object current() {
            return objects[i];
        }

        @Override
        public void next() {
            if (i < objects.length) {
                i++;
            }
        }
    }

    public Selector getSelector() {
        return new SSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; ++i) {
            sequence.add(Integer.toString(i));
        }

        Selector selector1 = sequence.getSelector();

        while (!selector1.end()) {
            System.out.println((String) selector1.current());
            selector1.next();
        }
    }
}
