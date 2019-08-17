package com.think.chapter8;

import java.util.Hashtable;

/**
 * Simple demostratioins of Hashtable
 */

class Counter {
    int i = 1;

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

public class Statistics {

    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        for (int i = 0; i < 10000; i++) {
            Integer integer = new Integer((int) (Math.random() * 20));
            if (hashtable.containsKey(integer)) {
                ((Counter) hashtable.get(integer)).i++;
            } else {
                hashtable.put(integer, new Counter());
            }
        }
        System.out.println(hashtable);
    }
}
