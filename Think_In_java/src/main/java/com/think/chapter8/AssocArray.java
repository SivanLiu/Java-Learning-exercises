package com.think.chapter8;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Simple version of a Dictionary
 */
public class AssocArray {
    private Vector keys = new Vector();
    private Vector values = new Vector();

    public int size() {
        return keys.size();
    }

    public boolean isEmpty() {
        return keys.isEmpty();
    }

    public Object put(Object key, Object value) {
        keys.addElement(key);
        values.addElement(value);
        return key;
    }

    public Object get(Object key) {
        int index = keys.indexOf(key);
        if (index == -1) {
            return null;
        }

        return values.elementAt(index);
    }

    public Object remove(Object key) {
        int index = keys.indexOf(key);
        if (index == -1) {
            return null;
        }

        keys.removeElement(index);
        Object returnval = values.elementAt(index);
        values.removeElement(index);
        return returnval;
    }

    public Enumeration keys() {
        return keys.elements();
    }

    public Enumeration elements() {
        return values.elements();
    }

    public static void main(String[] args) {
        AssocArray assocArray = new AssocArray();
        for (char c = 'a'; c <= 'z'; c++) {
            assocArray.put(String.valueOf(c), String.valueOf(c).toUpperCase());
        }

        char[] chars = { 'a', 'e', 'i', 'o', 'u' };
        for (int i = 0; i < chars.length; i++) {
            System.out.println("Uppercase: " + assocArray.get(String.valueOf(chars[i])));
        }
    }
}
