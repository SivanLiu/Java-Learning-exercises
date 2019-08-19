package com.think.chapter10;

import com.think.chapter8.StrSortVector;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Displays sorted directory listing
 */
public class SortedDirList {
    private File path;
    private String[] list;

    public SortedDirList(final String afn) {
        path = new File(".");
        if (afn == null) {
            list = path.list();
        } else {
            list = path.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    String f = new File(name).getName();
                    return f.contains(afn);
                }
            });

            sort();
        }
    }

    void print() {
        for (int i = 0; i < list.length; ++i) {
            System.out.println(list[i]);
        }
    }

    private void sort() {
        StrSortVector strSortVector = new StrSortVector();
        for (int i = 0; i < list.length; ++i) {
            strSortVector.addElement(list[i]);
        }

        for (int i = 0; i < list.length; ++i) {
            list[i] = strSortVector.elementAt(i);
        }
    }

    public static void main(String[] args) {
        SortedDirList sortedDirList;
        if (args.length == 0) {
            sortedDirList = new SortedDirList(null);
        } else {
            sortedDirList = new SortedDirList(args[0]);
        }
        sortedDirList.print();
    }
}
