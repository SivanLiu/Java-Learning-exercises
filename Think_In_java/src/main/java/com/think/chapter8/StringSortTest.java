package com.think.chapter8;

import java.util.Enumeration;

/**
 * Testing the generic sorting Vector
 */
public class StringSortTest {
    static class StringCompare implements Compare {

        @Override
        public boolean lessThan(Object lhs, Object rhs) {
            return ((String) lhs).toLowerCase().compareTo(((String) rhs).toLowerCase()) < 0;
        }

        @Override
        public boolean lessThanOrEqual(Object lhs, Object rhs) {
            return ((String) lhs).toLowerCase().compareTo(((String) rhs).toLowerCase()) <= 0;
        }
    }

    public static void main(String[] args) {
        SortVector sortVector = new SortVector(new StringCompare());
        sortVector.addElement("d");
        sortVector.addElement("A");
        sortVector.addElement("C");
        sortVector.addElement("c");
        sortVector.addElement("b");
        sortVector.addElement("B");
        sortVector.addElement("D");
        sortVector.addElement("a");
        sortVector.sort();
        Enumeration enumeration = sortVector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

    }
}
