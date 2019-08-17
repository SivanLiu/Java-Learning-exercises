package com.think.chapter8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * A simple example using the new Collections
 */
public class SimpleCollection {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        for (int i = 0; i < 10; ++i) {
            collection.add(Integer.toString(i));
        }

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
