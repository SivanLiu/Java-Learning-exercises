package com.think.chapter10;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Displays directory listing
 */
public class DirList {

    public static void main(String[] args) {
        try {
            File path = new File(".");
            System.out.println("path = " + path.getAbsolutePath());
            String[] list;
            if (args.length == 0) {
                list = path.list();
            } else {
                list = path.list(new DirFilter(args[0]));
            }

            for (int i = 0; i < list.length; ++i) {
                System.out.println(list[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DirFilter implements FilenameFilter {

    String afn;

    DirFilter(String afn) {
        this.afn = afn;
    }

    @Override
    public boolean accept(File dir, String name) {
        //Strip path information
        String f = new File(name).getName();
        return f.contains(afn);
    }
}
