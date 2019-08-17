package com.think.chapter8;

import java.util.Enumeration;

/**
 * Automatically sorted Vector that accepts and produces only Strings
 */
public class StrSortVector {
    private SortVector vector = new SortVector(
            //Anonymous inner class;
            new Compare() {
                @Override
                public boolean lessThan(Object lhs, Object rhs) {
                    return ((String) lhs).toLowerCase().compareTo(((String) rhs).toLowerCase()) < 0;
                }

                @Override
                public boolean lessThanOrEqual(Object lhs, Object rhs) {
                    return ((String) lhs).toLowerCase().compareTo(((String) rhs).toLowerCase()) <= 0;
                }
            });

    private boolean sorted = false;

    public void addElement(String s) {
        vector.addElement(s);
        sorted = false;
    }

    public String elementAt(int index) {
        if (!sorted) {
            vector.sort();
            sorted = false;
        }

        return (String)vector.elementAt(index);
    }

    public Enumeration elements(){
        if(!sorted){
            vector.sort();
            sorted = false;
        }

        return vector.elements();
    }

    public static void main(String[] args) {
        StrSortVector strSortVector = new StrSortVector();
        strSortVector.addElement("d");
        strSortVector.addElement("A");
        strSortVector.addElement("C");
        strSortVector.addElement("c");
        strSortVector.addElement("b");
        strSortVector.addElement("B");
        strSortVector.addElement("D");
        strSortVector.addElement("a");
        Enumeration enumeration = strSortVector.elements();
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
    }
}
